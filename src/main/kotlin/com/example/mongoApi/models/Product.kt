package com.example.mongoApi.models

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

@Document
class Product(
    @Id val id: String? = null,
    var name: String,
    var manufacturer: Brand,
    var productionDate: LocalDateTime,
    var available: Boolean
)