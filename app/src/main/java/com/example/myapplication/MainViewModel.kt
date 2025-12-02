package com.example.myapplication

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.myapplication.domain.manager.usecases.AppEntryUsecases
import com.example.myapplication.presentation.Route
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.launchIn
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

@HiltViewModel
class MainViewModel @Inject constructor(
    private val appEntryUsecases: AppEntryUsecases
): ViewModel() {
    var splashCondition by mutableStateOf(true)
        private set

    var startDestination by mutableStateOf(Route.AppStartNavigation.route)
        private set


    init {
        appEntryUsecases.readAppEntry().onEach { shouldStartFromHomeScreen ->
            if (shouldStartFromHomeScreen) {
                startDestination = Route.NewsNavigation.route
            } else {
                startDestination = Route.AppStartNavigation.route
            }
            splashCondition = false
        }.launchIn(viewModelScope)
    }
}