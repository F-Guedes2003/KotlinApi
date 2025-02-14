package com.example.mongoApi.models

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDate

@Document
class Product(
    @Id val id: String? = null,
    var name: String,
    var manufacturer: String,
    var productionDate: LocalDate,
    var available: Boolean
)