package com.plcoding.graphqlcountriesapp.presentation

import androidx.lifecycle.ViewModel
import com.plcoding.graphqlcountriesapp.domain.use_cases.GetCountriesUseCase
import com.plcoding.graphqlcountriesapp.domain.use_cases.GetCountryUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class CountriesViewModel(
    private val getCountryUseCase: GetCountryUseCase,
    private val getCountriesUseCase: GetCountriesUseCase
):ViewModel(){

private val _state = MutableStateFlow(CountriesState())
    val state = _state.asStateFlow()
}