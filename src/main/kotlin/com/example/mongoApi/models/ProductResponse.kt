package com.example.mongoApi.models

import org.springframework.data.annotation.Id
import java.time.LocalDate

class ProductResponse(
    @Id val id: String? = null,
    var name: String,
    var manufacturer: Brand,
    var productionDate: LocalDate,
    var available: Boolean
)