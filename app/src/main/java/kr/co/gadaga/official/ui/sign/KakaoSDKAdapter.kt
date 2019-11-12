package kr.co.gadaga.official.ui.sign

import android.content.Context
import com.kakao.auth.*

class KakaoSDKAdapter(private val applicationContext: Context): KakaoAdapter() {

    override fun getSessionConfig(): ISessionConfig {
        return object :ISessionConfig{
            override fun getAuthTypes(): Array<AuthType> = arrayOf(AuthType.KAKAO_TALK)

            override fun isUsingWebviewTimer(): Boolean = false

            override fun getApprovalType(): ApprovalType = ApprovalType.INDIVIDUAL

            override fun isSaveFormData(): Boolean = true

            override fun isSecureMode(): Boolean = true
        }
    }

    override fun getPushConfig(): IPushConfig {
        return super.getPushConfig()
    }

    override fun getApplicationConfig(): IApplicationConfig {
        return IApplicationConfig { applicationContext }
    }
}