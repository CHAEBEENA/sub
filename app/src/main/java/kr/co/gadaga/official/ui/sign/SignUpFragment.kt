package kr.co.gadaga.official.ui.sign

import android.content.IntentFilter
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.google.android.gms.auth.api.phone.SmsRetriever
import kr.co.gadaga.official.R

class SignUpFragment : Fragment() {

    private lateinit var viewModel: SignUpViewModel

    private val mOTPReceiveListener = object : OTPReceiveListener {

        override fun onOTPReceived(otp: String) {
            Log.i("chaebeen", "onOTPReceived, 인증번호: $otp")

            /* 테스트 */
            val verificationEditText = EditText(requireContext())
            val verificationNextButton = Button(requireContext())

            verificationEditText.apply {
                setText(otp)

                addTextChangedListener {
                    if(verificationEditText.text.toString() == otp) {
                        /* 성공 */
                        Toast.makeText(requireContext(), "인증 성공", Toast.LENGTH_SHORT).show()
                        verificationNextButton.setBackgroundResource(R.color.color_app_primary)
                    } else {
                        /* 실패 */
                        Toast.makeText(requireContext(), "인증 실패", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }

        override fun onOTPTimeOut() {
            Toast.makeText(requireContext(), "입력 가능한 시간이 초과되었습니다.", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_sign_up, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(SignUpViewModel::class.java)
    }

    private fun registerSmsReceiver() = requireActivity().applicationContext
        .registerReceiver(
            SmsReceiver(mOTPReceiveListener),
            IntentFilter().apply { addAction(SmsRetriever.SMS_RETRIEVED_ACTION) }
        )

    private fun startSmsListener() {
        SmsRetriever.getClient(requireContext()).startSmsRetriever()
            .addOnSuccessListener {
                Toast.makeText(requireContext(), "startSmsRetriever() on success", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener { exception ->
                Toast.makeText(requireContext(), "startSmsRetriever() on failure", Toast.LENGTH_SHORT).show()
            }
    }
}
