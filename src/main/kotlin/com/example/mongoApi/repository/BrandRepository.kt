package com.example.mongoApi.repository

import com.example.mongoApi.models.Brand
import org.springframework.data.mongodb.repository.MongoRepository

interface BrandRepository: MongoRepository<Brand, String>  {
}