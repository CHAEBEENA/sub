package kr.co.gadaga.official.ui.sign

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.google.android.gms.auth.api.phone.SmsRetriever
import com.google.android.gms.common.api.CommonStatusCodes
import com.google.android.gms.common.api.Status
import java.util.regex.Pattern

class SmsReceiver(private val otpReceiveListener: OTPReceiveListener): BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        if (SmsRetriever.SMS_RETRIEVED_ACTION == intent?.action) {

            val extras = intent.extras
            val status = extras?.get(SmsRetriever.EXTRA_STATUS) as Status

            when (status.statusCode) {
                CommonStatusCodes.SUCCESS -> {
                    /* SMS 본문 */
                    val message = extras.get(SmsRetriever.EXTRA_SMS_MESSAGE) as String
                    val otp = extractNumber(message)

                    otpReceiveListener.onOTPReceived(otp)
                }

                CommonStatusCodes.TIMEOUT -> {
                    otpReceiveListener.onOTPTimeOut()
                    // Toast.makeText(context, "입력가능한 시간이 초과되었습니다.", Toast.LENGTH_SHORT).show()
                }

            }
        }
    }

    /* TODO(SMS 서비스 테스트) */
    private fun extractNumber(otp: String): String {
        return Pattern.compile("\\d+")
            .matcher(otp)
            .let { matcher ->
                var number = ""
                while (matcher.find()) {
                    number += matcher.group()
                }

                number
            }
            .substring(0, 6)
    }

}

interface OTPReceiveListener {

    fun onOTPReceived(otp: String)

    fun onOTPTimeOut()
}