package com.example.tbcexercises.data.repository.company

import com.example.tbcexercises.data.mappers.company.toDomainCompany
import com.example.tbcexercises.data.remote.service.CompanyService
import com.example.tbcexercises.domain.model.cart.Company
import com.example.tbcexercises.domain.repository.company.CompanyRepository
import com.example.tbcexercises.utils.network_helper.Resource
import com.example.tbcexercises.utils.network_helper.handleNetworkRequest
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class CompanyRepositoryImpl @Inject constructor(private val companyService: CompanyService) :
    CompanyRepository {
    override fun getCompanies(): Flow<Resource<List<Company>>> {
        return handleNetworkRequest { companyService.getCompanies() }.map { response ->
            when (response) {
                is Resource.Success -> {
                    val companies = response.data.mapIndexed { index, company ->
                        company.toDomainCompany(isClicked = index == 0)
                    }
                    Resource.Success(companies)
                }

                is Resource.Error -> {
                    Resource.Error(response.message)
                }

                is Resource.Loading -> Resource.Loading
            }
        }
    }
}