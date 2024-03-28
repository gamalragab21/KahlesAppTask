package net.gamal.kahlesapptask.ui.fragments.entryPoint

import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import net.gamal.kahlesapptask.android.base.BaseFragment
import net.gamal.kahlesapptask.android.extentions.navigateSafe
import net.gamal.kahlesapptask.android.extentions.observe
import net.gamal.kahlesapptask.android.helpers.logging.getClassLogger
import net.gamal.kahlesapptask.databinding.FragmentEntryPointBinding
import net.gamal.kahlesapptask.viewModel.CurrentAction
import net.soft.petFinder.ui.fragments.entryPoint.EntryPointVM

@AndroidEntryPoint
class EntryPointFragment : BaseFragment<FragmentEntryPointBinding>() {
    private val entryPointVM: EntryPointVM by viewModels()
    override fun onFragmentReady() {}

    override fun subscribeToObservables() {
        entryPointVM.apply {
            observe(viewState) {
                handleUIState(it)
            }
        }
    }

    private fun handleUIState(state: EntryPointState) {
        getClassLogger().error("handleUIState: $state")

        when (state) {
            is EntryPointState.Failure -> handleHttpsStatusCode(state.exception)
            is EntryPointState.Loading -> binding.animationView.isIndeterminate = state.loading
            EntryPointState.NavigateToHomeScreen -> navigateSafe(EntryPointFragmentDirections.actionEntryPointFragmentToHomeFragment())
        }
    }

    override fun onRetryCurrentAction(currentAction: CurrentAction?, message: String) {}
}