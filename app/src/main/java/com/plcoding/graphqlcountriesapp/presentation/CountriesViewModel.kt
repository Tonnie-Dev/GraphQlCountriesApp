package com.plcoding.graphqlcountriesapp.presentation

import androidx.lifecycle.ViewModel
import com.plcoding.graphqlcountriesapp.domain.use_cases.GetCountriesUseCase
import com.plcoding.graphqlcountriesapp.domain.use_cases.GetCountryUseCase

class CountriesViewModel(
    private val getCountryUseCase: GetCountryUseCase,
    private val getCountriesUseCase: GetCountriesUseCase
):ViewModel(){


}