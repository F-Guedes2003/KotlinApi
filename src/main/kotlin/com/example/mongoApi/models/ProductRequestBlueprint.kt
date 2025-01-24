package com.example.mongoApi.models

import java.time.LocalDate

class ProductRequestBlueprint(
    var name: String,
    var manufacturerName: String,
    var productionDate: LocalDate,
    var available: Boolean
) {
}