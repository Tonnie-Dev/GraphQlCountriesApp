package com.plcoding.graphqlcountriesapp.presentation

import com.plcoding.graphqlcountriesapp.domain.model.DetailedCountry
import com.plcoding.graphqlcountriesapp.domain.model.SimpleCountry
import java.util.*

data class CountriesState(
    val countries: List<SimpleCountry> = emptyList(),
    val isLoading: Boolean = false,
    val selectedCountry: DetailedCountry? = null
)
