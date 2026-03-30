package com.example.to_do_app_jetpackcompose.presentation.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.to_do_app_jetpackcompose.presentation.home.viewModel.HomeViewModel

@Composable
fun HomeRootScreen(viewModel: HomeViewModel = hiltViewModel()) {

    val state by viewModel.state.collectAsStateWithLifecycle()

    HomeScreen(
        state = state,
        postIntent = viewModel::onEvent,
        effect = viewModel.effect
    )
}