package com.example.mongoApi.controllers

import com.example.mongoApi.models.ProductRequestBlueprint
import com.example.mongoApi.services.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/products")
class ProductController(
    @Autowired val service: ProductService
) {

    @GetMapping
    fun getAll() = service.getAll();

    @GetMapping(path = ["{id}"])
    fun getOne(@PathVariable id: String) = service.getOne(id);

    @PostMapping
    fun create(@RequestBody request: ProductRequestBlueprint) = service.create(request);

}