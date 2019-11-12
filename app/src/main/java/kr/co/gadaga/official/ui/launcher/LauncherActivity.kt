package kr.co.gadaga.official.ui.launcher

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import kr.co.gadaga.official.ext.viewModelProvider
import kr.co.gadaga.official.ui.MainActivity
import kr.co.gadaga.official.ui.onboarding.OnboardingActivity
import kr.co.gadaga.official.util.EventObserver

class LauncherActivity : AppCompatActivity() {

    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel: LauncherViewModel = viewModelProvider(viewModelFactory)

        viewModel.launchDestination.observe(this, EventObserver { destination ->
            when(destination) {
                LaunchDestination.MAIN_ACTIVITY -> startActivity(Intent(this, MainActivity::class.java))
                LaunchDestination.ONBOADRING -> startActivity(Intent(this, OnboardingActivity::class.java))
            }
            finish()
        })
    }
}
