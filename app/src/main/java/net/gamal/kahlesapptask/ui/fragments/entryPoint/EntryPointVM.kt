package net.soft.petFinder.ui.fragments.entryPoint

import android.app.Application
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import net.gamal.kahlesapptask.ui.fragments.entryPoint.EntryPointState
import net.gamal.kahlesapptask.viewModel.AndroidBaseViewModel
import javax.inject.Inject

@HiltViewModel
class EntryPointVM @Inject constructor(
    context: Application,
) : AndroidBaseViewModel<EntryPointState>(context) {
    private fun waitForSplashTime() {
        viewModelScope.launch {
            produce(EntryPointState.Loading(true))
            delay(5000) // Delay for 5 seconds
            produce(EntryPointState.NavigateToHomeScreen)
            produce(EntryPointState.Loading(false))
        }
    }

    init {
        waitForSplashTime()
    }
}