package com.example.mongoApi.controllers

import com.example.mongoApi.services.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/products")
class ProductController(
    @Autowired val service: ProductService
) {
    fun getAll() = service.getAll;
}