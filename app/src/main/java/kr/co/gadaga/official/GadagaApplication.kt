package kr.co.gadaga.official

import android.app.Application
import com.kakao.auth.KakaoSDK
import kr.co.gadaga.official.ui.sign.KakaoSDKAdapter
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule

class GadagaApplication: Application(), KodeinAware {

    override val kodein = Kodein.lazy {
        /* AndroidX 모듈 */
        import(androidXModule(this@GadagaApplication))


    }

    override fun onCreate() {
        super.onCreate()

        KakaoSDK.init(KakaoSDKAdapter(this))
    }
}