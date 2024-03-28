package net.gamal.kahlesapptask.ui.fragments.entryPoint

import net.gamal.kahlesapptask.core.common.data.model.exception.LeonException
import net.gamal.kahlesapptask.viewModel.ViewState

sealed class EntryPointState : ViewState {
    data class Loading(val loading: Boolean) : EntryPointState()
    data class Failure(val exception: LeonException) : EntryPointState()
    data object NavigateToHomeScreen : EntryPointState()
}