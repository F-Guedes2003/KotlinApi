package com.example.mongoApi.models

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document

@Document
class Brand(
    @Id var id: String? = null,
    @Indexed(unique = true)
    var name: String? = null,
    var headquarter: String? = null
)