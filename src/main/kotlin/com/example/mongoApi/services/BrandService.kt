package com.example.mongoApi.services

import com.example.mongoApi.APIResponse
import com.example.mongoApi.exceptions.ElementNotFoundException
import com.example.mongoApi.exceptions.InvalidDataFormatException
import com.example.mongoApi.models.Brand
import com.example.mongoApi.repository.BrandRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class BrandService(@Autowired val repository: BrandRepository) {

    fun getAll(): List<Brand> = repository.findAll();

    fun getOneBrand(id: String): Brand? = repository.findById(id).orElseThrow { ElementNotFoundException("Element with the provided id not found!") };

    fun create(brand: Brand): ResponseEntity<APIResponse> {
        if(brand.name.isNullOrBlank()) throw InvalidDataFormatException("Name field must be filled!");

        if(brand.headquarter == null) throw InvalidDataFormatException("Headquarter field must be filled!");

        repository.insert(brand)

        val response = APIResponse(
            "User created with success!",
            HttpStatus.CREATED.value()
        )

        return ResponseEntity(
            response,
            HttpStatus.CREATED
        )
    };

    fun editBrand(request: Brand, id: String): ResponseEntity<APIResponse> {
        var brand = repository.findById(id).orElseThrow { ElementNotFoundException("Element with the provided id don't exists!"); };

        if(!request.name.isNullOrBlank()) brand.name = request.name;

        if(!request.headquarter.isNullOrBlank()) brand.headquarter = request.headquarter;

        repository.save(brand);

        val response = APIResponse(
            "Brand updated with success!",
            HttpStatus.OK.value()
        )

        return ResponseEntity(response, HttpStatus.OK);
    }
}