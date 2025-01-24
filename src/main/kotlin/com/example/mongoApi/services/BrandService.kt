package com.example.mongoApi.services

import com.example.mongoApi.models.Brand
import com.example.mongoApi.repository.BrandRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class BrandService(@Autowired val repository: BrandRepository) {

    fun getAll(): List<Brand> = repository.findAll();

    fun create(brand: Brand) = repository.insert(brand);
}