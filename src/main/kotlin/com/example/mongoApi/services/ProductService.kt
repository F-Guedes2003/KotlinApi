package com.example.mongoApi.services

import com.example.mongoApi.APIResponse
import com.example.mongoApi.exceptions.ElementNotFoundException
import com.example.mongoApi.models.Brand
import com.example.mongoApi.models.Product
import com.example.mongoApi.models.ProductRequestBlueprint
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

    fun getAll(): MutableList<Product> = repo.findAll();

    fun create(request: ProductRequestBlueprint): ResponseEntity<APIResponse> {
        val brand = brandRepo.findBrandByName(request.manufacturerName)
            ?: throw ElementNotFoundException("Manufacturer does not exists");

        val product = Product(
            name = request.name,
            manufacturer = brand,
            productionDate = request.productionDate,
            available = request.available
        )

        repo.insert(product);

        val response = APIResponse("Product created with success!", HttpStatus.CREATED.value());

        return ResponseEntity(
            response,
            HttpStatus.CREATED
        );
    }
}