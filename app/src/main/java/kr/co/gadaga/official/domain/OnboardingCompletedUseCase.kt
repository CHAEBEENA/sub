package kr.co.gadaga.official.domain

import kr.co.gadaga.official.data.prefs.PreferenceStorage

class OnboardingCompletedUseCase (
    private val preferenceStorage: PreferenceStorage
): UseCase<Unit, Boolean>() {

    override fun execute(parameters: Unit): Boolean = preferenceStorage.onboardingCompleted
}