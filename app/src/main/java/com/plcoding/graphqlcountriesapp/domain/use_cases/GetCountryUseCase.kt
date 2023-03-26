package com.plcoding.graphqlcountriesapp.domain.use_cases

import com.plcoding.graphqlcountriesapp.domain.CountryClient
import com.plcoding.graphqlcountriesapp.domain.model.DetailedCountry

class GetCountryUseCase(private val client:CountryClient){

    suspend fun execute(code:String):DetailedCountry?{

        return client.getCountry(code)
    }
}