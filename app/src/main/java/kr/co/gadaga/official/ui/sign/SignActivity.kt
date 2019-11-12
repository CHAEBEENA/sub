package kr.co.gadaga.official.ui.sign

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kr.co.gadaga.official.R
import kr.co.gadaga.official.ui.faq.FaqFragment
import kr.co.gadaga.official.ui.notice.NoticeFragment

class SignActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign)

        supportFragmentManager.beginTransaction()
            .replace(R.id.rootLayout,SignInFragment())
            .commit()
    }
}
