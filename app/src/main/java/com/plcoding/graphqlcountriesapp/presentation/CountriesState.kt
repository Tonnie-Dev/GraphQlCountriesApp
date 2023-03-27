package com.plcoding.graphqlcountriesapp.presentation

import com.plcoding.graphqlcountriesapp.domain.model.DetailedCountry
import java.util.*

data class CountriesState(
    val countries: List<Scanner> = emptyList(),
    val isLoading: Boolean = false,
    val selectedCountry: DetailedCountry? = null
)
