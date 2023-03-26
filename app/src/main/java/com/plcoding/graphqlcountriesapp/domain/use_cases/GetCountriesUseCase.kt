package com.plcoding.graphqlcountriesapp.domain.use_cases

import com.plcoding.graphqlcountriesapp.domain.CountryClient
import com.plcoding.graphqlcountriesapp.domain.model.SimpleCountry

class GetCountriesUseCase(private val countryClient: CountryClient) {

    suspend fun execute(): List<SimpleCountry> {

        return countryClient.getCountries()
                .sortedBy { it.name }
    }

}