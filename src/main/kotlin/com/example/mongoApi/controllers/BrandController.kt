package com.example.mongoApi.controllers

import com.example.mongoApi.APIResponse
import com.example.mongoApi.models.Brand
import com.example.mongoApi.services.BrandService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/v1/brands")
class BrandController(@Autowired val service: BrandService){

    @GetMapping()
    fun getBrands() = service.getAll();

    @GetMapping(path = ["{id}"])
    fun getOneBrand(@PathVariable id: String) = service.getOneBrand(id);

    @PostMapping()
    fun createBrand(@RequestBody brand: Brand): ResponseEntity<APIResponse> = service.create(brand);

    @PutMapping(path = ["/{id}"])
    fun editBrand(@RequestBody brand: Brand, @PathVariable id: String) = service.editBrand(brand, id);

    @DeleteMapping(path = ["{id}"])
    fun delete(@PathVariable id: String): ResponseEntity<APIResponse> = service.delete(id);
}