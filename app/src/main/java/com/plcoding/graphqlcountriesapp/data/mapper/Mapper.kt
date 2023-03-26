package com.plcoding.graphqlcountriesapp.data.mapper

import com.plcoding.CountriesQuery
import com.plcoding.CountryQuery
import com.plcoding.graphqlcountriesapp.domain.DetailedCountry
import com.plcoding.graphqlcountriesapp.domain.SimpleCountry

fun CountryQuery.Country.toDetailedCountry():DetailedCountry{

    return DetailedCountry(
            code = this.code    ,
            name = this.name,
            emoji = this.emoji,
            capital = this.capital?: "No Capital",
            currency = this.currency ?: "No Currency",
            languages = this.languages.mapNotNull{ it.name },
            continent = this.continent.name
    )
}

fun CountriesQuery.Country.toSimpleCountry():SimpleCountry = SimpleCountry(
        code = this.code,
        name = this.name,
        emoji = this.emoji,
        capital = this.capital ?: "No Capital"
)