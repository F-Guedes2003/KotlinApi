package com.example.mongoApi.repository

import com.example.mongoApi.models.Product
import org.springframework.data.mongodb.repository.MongoRepository

interface ProductRepository: MongoRepository<Product, String> {
}