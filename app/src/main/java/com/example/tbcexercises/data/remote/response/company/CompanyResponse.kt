package com.example.tbcexercises.data.remote.response.company

import kotlinx.serialization.Serializable

@Serializable
data class CompanyResponse(
    val id: Int,
    val company: String,
    val companyImgUrl: String
)
