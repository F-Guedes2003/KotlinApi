package com.example.mongoApi.controllers

import com.example.mongoApi.APIResponse
import com.example.mongoApi.models.Brand
import com.example.mongoApi.services.BrandService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/brands")
class BrandController(@Autowired val service: BrandService){

    @GetMapping()
    fun getBrands() = service.getAll();

    @PostMapping()
    fun createBrand(@RequestBody brand: Brand): ResponseEntity<APIResponse> = service.create(brand);

    @PutMapping(path = ["/{id}"])
    fun editBrand(@RequestBody brand: Brand, @PathVariable id: String) = service.editBrand(brand, id);
}