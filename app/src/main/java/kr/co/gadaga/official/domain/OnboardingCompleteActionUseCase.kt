package kr.co.gadaga.official.domain

import kr.co.gadaga.official.data.prefs.PreferenceStorage

class OnboardingCompleteActionUseCase(
    private val preferenceStorage: PreferenceStorage
): UseCase<Boolean, Unit>() {

    override fun execute(parameters: Boolean) {
        preferenceStorage.onboardingCompleted = parameters
    }
}