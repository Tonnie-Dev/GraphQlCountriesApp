package com.plcoding.graphqlcountriesapp.data

import com.apollographql.apollo3.ApolloClient
import com.plcoding.graphqlcountriesapp.domain.CountryClient
import com.plcoding.graphqlcountriesapp.domain.DetailedCountry
import com.plcoding.graphqlcountriesapp.domain.SimpleCountry

class ApolloCountryClient(private val apolloClient: ApolloClient):CountryClient {

    override suspend fun getCountries(): List<SimpleCountry> {
        TODO("Not yet implemented")
    }

    override suspend fun getCountry(code: String): DetailedCountry? {
        TODO("Not yet implemented")
    }
}