package kr.co.gadaga.official.ui.launcher

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kr.co.gadaga.official.domain.OnboardingCompletedUseCase
import kr.co.gadaga.official.ext.map
import kr.co.gadaga.official.util.Event
import kr.co.gadaga.official.util.Result

class LauncherViewModel constructor(
    onBoardingCompletedUseCase: OnboardingCompletedUseCase
) : ViewModel() {

    private val onboardingCompletedResult = MutableLiveData<Result<Boolean>>()
    val launchDestination: LiveData<Event<LaunchDestination>>

    init {
        onBoardingCompletedUseCase(Unit, onboardingCompletedResult)
        launchDestination = onboardingCompletedResult.map {
            if(((it as? Result.Success)?.data == false)) {
                Event(LaunchDestination.ONBOADRING)
            } else {
                Event(LaunchDestination.MAIN_ACTIVITY)
            }
        }
    }
}

enum class LaunchDestination {
    ONBOADRING, MAIN_ACTIVITY
}