package com.example.mongoApi.services

import com.example.mongoApi.APIResponse
import com.example.mongoApi.models.Brand
import com.example.mongoApi.repository.BrandRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class BrandService(@Autowired val repository: BrandRepository) {

    fun getAll(): List<Brand> = repository.findAll();

    fun create(brand: Brand): ResponseEntity<APIResponse> {
        repository.insert(brand)

        val response = APIResponse(
            "User created with success!",
            HttpStatus.CREATED
        )

        return ResponseEntity(
            response,
            HttpStatus.CREATED
        )
    };

    fun editBrand(request: Brand, id: String) {
        var brand = repository.findById(id).orElseThrow { IllegalArgumentException(); };
    }
}