package com.plcoding.graphqlcountriesapp.domain

import com.plcoding.graphqlcountriesapp.domain.model.DetailedCountry
import com.plcoding.graphqlcountriesapp.domain.model.SimpleCountry

interface CountryClient {
    suspend fun getCountries():List<SimpleCountry>
    suspend fun getCountry(code:String): DetailedCountry?
}