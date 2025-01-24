package com.example.mongoApi.models

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
class Brand(
    @Id val id: String,
    var name: String,
    var headquarter: String
)