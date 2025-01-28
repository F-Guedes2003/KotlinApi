package com.example.mongoApi.repository

import com.example.mongoApi.models.Brand
import org.springframework.data.mongodb.repository.MongoRepository
import java.util.Optional

interface BrandRepository: MongoRepository<Brand, String>  {
    fun findBrandByName(name: String): Optional<Brand>;
}