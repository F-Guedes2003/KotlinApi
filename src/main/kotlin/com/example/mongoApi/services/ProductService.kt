package com.example.mongoApi.services

import com.example.mongoApi.APIResponse
import com.example.mongoApi.exceptions.ElementNotFoundException
import com.example.mongoApi.exceptions.InvalidDataFormatException
import com.example.mongoApi.models.Brand
import com.example.mongoApi.models.Product
import com.example.mongoApi.models.ProductRequestBlueprint
import com.example.mongoApi.models.ProductResponse
import com.example.mongoApi.repository.BrandRepository
import com.example.mongoApi.repository.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping

@Service
class ProductService(
    @Autowired val repo: ProductRepository,
    @Autowired val brandRepo: BrandRepository
) {

    fun getAll(): List<ProductResponse> {
        val products = repo.findAll();

        return products.map { e -> getProductResponse(e); }
    }

    fun getOne(id: String): ProductResponse? {
        val product = repo.findById(id).orElseThrow{ ElementNotFoundException("Element with the provideded if not found") };
        val brand = brandRepo.findById(product.manufacturer).orElseThrow { ElementNotFoundException("Manufacturer with the provided id not found!") };

        return ProductResponse(product.id, product.name, brand, product.productionDate, product.available);
    }

    fun create(request: ProductRequestBlueprint): ResponseEntity<APIResponse> {
        if(request.name.isNullOrBlank()) throw InvalidDataFormatException("name field must be filled!");

        if(request.productionDate == null) throw InvalidDataFormatException("Production date field must be filled!");

        if(request.available == null) throw InvalidDataFormatException("Available field must be filled!");

        if(request.manufacturerName.isNullOrBlank()) throw InvalidDataFormatException("Manufacturer name must be filled!");

        val brand = brandRepo.findBrandByName(request.manufacturerName!!).orElseThrow { ElementNotFoundException("Element with the provided id does not exists!") }

        val product = Product(
            name = request.name!!,
            manufacturer = brand.id!!,
            productionDate = request.productionDate!!,
            available = request.available!!
        )

        repo.insert(product);

        val response = APIResponse("Product created with success!", HttpStatus.CREATED.value());

        return ResponseEntity(
            response,
            HttpStatus.CREATED
        );
    }

    fun update(id: String, request: ProductRequestBlueprint): ResponseEntity<APIResponse> {
        val product = repo.findById(id).orElseThrow { ElementNotFoundException("Element with the provided id does not exists!") };

        if(!request.name.isNullOrBlank()) product.name = request.name ?: product.name;

        if(request.available != null) product.available = request.available ?: product.available;

        if(request.productionDate != null) product.productionDate = request.productionDate ?: product.productionDate;

        if(!request.manufacturerName.isNullOrBlank() ) {
            val brand = brandRepo.findBrandByName(request.manufacturerName!!).orElseThrow { ElementNotFoundException("Element with the provided id does not exists") }

            product.manufacturer = brand.id!!;
        }

        repo.save(product);

        val response = APIResponse(
            "Element updated with success!",
            HttpStatus.OK.value()
        )

        return ResponseEntity(response, HttpStatus.OK)
    }

    fun delete(id: String): ResponseEntity<APIResponse> {
        repo.findById(id).orElseThrow { ElementNotFoundException("Element with the provided id not found") }
        repo.deleteById(id);
        val response = APIResponse(
            "Element removed with success!",
            HttpStatus.OK.value()
        )

        return ResponseEntity(response, HttpStatus.OK);
    }

    private fun getProductResponse(e: Product): ProductResponse {
        val brand = brandRepo.findById(e.manufacturer)
            .orElseThrow { ElementNotFoundException("Element with the provided id does not exists") };

        return ProductResponse(e.id, e.name, brand, e.productionDate, e.available)
    };
}