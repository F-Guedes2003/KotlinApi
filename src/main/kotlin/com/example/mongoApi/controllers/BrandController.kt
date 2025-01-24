package com.example.mongoApi.controllers

import com.example.mongoApi.models.Brand
import com.example.mongoApi.services.BrandService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/brands")
class BrandController(@Autowired val service: BrandService){

    @GetMapping()
    fun getBrands() = service.getAll();

    @PostMapping()
    fun createBrand(@RequestBody brand: Brand) = service.create(brand);
}