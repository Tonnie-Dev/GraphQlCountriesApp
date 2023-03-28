package com.plcoding.graphqlcountriesapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.plcoding.graphqlcountriesapp.domain.use_cases.GetCountriesUseCase
import com.plcoding.graphqlcountriesapp.domain.use_cases.GetCountryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CountriesViewModel @Inject constructor(
    private val getCountryUseCase: GetCountryUseCase,
    private val getCountriesUseCase: GetCountriesUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(CountriesState())
    val state = _state.asStateFlow()


    init {

        viewModelScope.launch {

            _state.update { it.copy(isLoading = true) }

            /*This will suspend for amount of time it takes to finish the request
            * and after that isLoading will be set to false*/

            _state.update { it.copy(countries = getCountriesUseCase.execute(), isLoading = false) }
        }
    }


    fun selectCountry(code: String) {

        viewModelScope.launch {

            _state.value = _state.value.copy(selectedCountry = getCountryUseCase.execute(code))
          //  _state.update { it.copy(selectedCountry = getCountryUseCase.execute(code)) }
        }
    }


    fun dismissCountryDialog(){

        _state.update { it.copy(selectedCountry = null) }
    }
}