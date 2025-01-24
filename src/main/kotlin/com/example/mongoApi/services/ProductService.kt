package com.example.mongoApi.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ProductService(@Autowired val repo: ProductRepository) {
}