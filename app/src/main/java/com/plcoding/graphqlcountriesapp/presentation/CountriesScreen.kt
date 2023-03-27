package com.plcoding.graphqlcountriesapp.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.hilt.navigation.compose.hiltViewModel
import com.plcoding.graphqlcountriesapp.domain.model.DetailedCountry
import com.plcoding.graphqlcountriesapp.domain.model.SimpleCountry

@Composable
fun CountriesScreen(
    viewModel: CountriesViewModel = hiltViewModel(),
    onSelectCountry: (String) -> Unit,
    onDismissCountryDialog: () -> Unit
) {

    val state by viewModel.state.collectAsState()
    Box(modifier = Modifier.fillMaxSize()) {

        if (state.isLoading) {

            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }

        LazyColumn(modifier = Modifier.fillMaxSize(), content = {

            items(state.countries) {

                country ->
                CountryItem(country = country,
                        modifier = Modifier
                                .fillMaxWidth()
                                .clickable { viewModel.selectCountry(country.code) }
                                .padding(16.dp)
                )


            }
        })
    }
}


@Composable
fun CountryItem(country: SimpleCountry, modifier: Modifier = Modifier) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        Text(text = country.emoji, fontSize = 30.sp)
        Spacer(modifier = Modifier.width(16.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(text = country.name, fontSize = 24.sp)
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = country.capital)
        }
    }
}

@Composable
private fun CountryDialog(
    country: DetailedCountry,
    onDismissCountryDialog: () -> Unit,
    modifier: Modifier = Modifier
) {

    val joinedLanguages = remember(country.languages) { country.languages.joinToString() }
    Dialog(onDismissRequest = onDismissCountryDialog) {

        Column(modifier = modifier) {

            Row(modifier = Modifier.fillMaxWidth()) {

                Text(text = country.emoji, fontSize = 30.sp)
                Spacer(modifier = Modifier.width(16.dp))
                Text(text = country.name, fontSize = 24.sp)
            }
            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "Continent: ${country.continent}")
            Spacer(modifier = Modifier.height(8.dp))

            Text(text = "Currency: ${country.currency}")
            Spacer(modifier = Modifier.height(8.dp))

            Text(text = "Capital: ${country.capital}")
            Spacer(modifier = Modifier.height(8.dp))

            Text(text = "Languages(s): $joinedLanguages")
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}