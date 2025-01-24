package com.example.mongoApi.services

import com.example.mongoApi.repository.BrandRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class BrandService(@Autowired repository: BrandRepository) {
}