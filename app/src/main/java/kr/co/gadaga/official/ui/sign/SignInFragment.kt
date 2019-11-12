package kr.co.gadaga.official.ui.sign

import android.annotation.SuppressLint
import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import com.kakao.auth.AuthType
import com.kakao.auth.Session
import com.nhn.android.naverlogin.OAuthLogin
import com.nhn.android.naverlogin.OAuthLoginHandler
import com.nhn.android.naverlogin.data.OAuthLoginState
import kotlinx.android.synthetic.main.fragment_sign_in.view.*
import kr.co.gadaga.official.R
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class SignInFragment : Fragment() {

    private lateinit var viewModel: SignInViewModel
    private var callback: KakaoSessionCallback= KakaoSessionCallback()

    private lateinit var auth : FirebaseAuth
    private lateinit var nhnOAuthLoginModule : OAuthLogin

    private lateinit var googleSignInClient: GoogleSignInClient

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_sign_in, container, false)

        //카카오
        view.kakao_login_btn.setOnClickListener {
            Log.e("tag","kakaoclick")
            val session = Session.getCurrentSession()
            session.addCallback(callback)
            session.open(AuthType.KAKAO_LOGIN_ALL, this)
        }

        //구글
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(requireActivity(),gso)

        auth = FirebaseAuth.getInstance()

        view.signInButton.setOnClickListener { signIn() }
        view.signOutButton.setOnClickListener { signOut()  }
        view.disconnectButton.setOnClickListener { revokeAccess() }

        //네이버
        nhnOAuthLoginModule = OAuthLogin.getInstance()
        nhnOAuthLoginModule.init(
            requireActivity(), getString(R.string.nhn_oauth_client_id),
            getString(R.string.nhn_oauth_client_secret),
            getString(R.string.nhn_oauth_client_name)
        )

        view.button_naverlogin.setOnClickListener {
            nhnSignIn()
        }


        return view

    }

    override fun onStart() {
        super.onStart()

        val currentUser = auth.currentUser
        updateUI(currentUser)
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                // Google Sign In was successful, authenticate with Firebase
                val account = task.getResult(ApiException::class.java)
                firebaseAuthWithGoogle(account!!)
            } catch (e: ApiException) {
                // Google Sign In failed, update UI appropriately
                Log.w(TAG, "Google sign in failed", e)
                updateUI(null)
            }
        }
    }

    private fun firebaseAuthWithGoogle(acct: GoogleSignInAccount) {
        Log.e("tag", "firebaseAuthWithGoogle:" + acct.id!!)
        val credential = GoogleAuthProvider.getCredential(acct.idToken, null)

        auth.signInWithCredential(credential)
            .addOnCompleteListener(requireActivity()) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "signInWithCredential:success")
                    val user = auth.currentUser
                    updateUI(user)
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "signInWithCredential:failure", task.exception)
                    Snackbar.make(requireView(), "Authentication Failed.", Snackbar.LENGTH_SHORT).show()
                    updateUI(null)
                }
            }
    }

    private fun signIn() {
        val signInIntent = googleSignInClient.signInIntent
        startActivityForResult(signInIntent, RC_SIGN_IN)
    }

    private fun signOut() {
        // Firebase sign out
        auth.signOut()
        // Google sign out
        googleSignInClient.signOut().addOnCompleteListener(requireActivity()) {
            updateUI(null)
        }
    }

    private fun revokeAccess() {
        // Firebase sign out
        auth.signOut()
        // Google revoke access
        googleSignInClient.revokeAccess().addOnCompleteListener(requireActivity()) {
            updateUI(null)
        }
    }

    private fun updateUI(user: FirebaseUser?) {
        // hideProgressDialog()
        if (user != null) {
            Log.e("Tag","Email: " +getString(R.string.google_status_fmt, user.email))
            Log.e("Tag","Phone number" + getString(R.string.google_status_fmt,user.phoneNumber))
            Log.e("Tag",getString(R.string.google_status_fmt,user.displayName))
            Log.e("Tag",getString(R.string.firebase_status_fmt, user.uid))
            Toast.makeText(requireContext(),"Signed In",Toast.LENGTH_SHORT).show()

        } else {
           Toast.makeText(requireContext(),"Signed Out",Toast.LENGTH_SHORT).show()
            Log.e("Tag","SignOut")

        }
    }

    companion object {
        private const val TAG = "GoogleActivity"
        private const val RC_SIGN_IN = 9001
    }


    //로그인 성공시 호출
    fun successLogin() {
        Toast.makeText(requireContext(), "네이버 로그인 성공", Toast.LENGTH_SHORT).show()
    }

    //네이버 로그인 콜백
    private fun nhnSignIn() {
        if (nhnOAuthLoginModule.getState(requireActivity()) == OAuthLoginState.OK) {
            Log.d("TAG", "Nhn status don't need login")
            RequestNHNLoginApiTask().execute()

            val accessToken = nhnOAuthLoginModule.getAccessToken(requireActivity())
            NaverProfileTask().execute(accessToken)


        } else {
            Log.d("TAG", "Nhn status need login")
            nhnOAuthLoginModule.startOauthLoginActivity(requireActivity(), @SuppressLint("HandlerLeak")
            object : OAuthLoginHandler() {
                override fun run(success: Boolean) {
                    if (success) {

                        val accessToken = nhnOAuthLoginModule.getAccessToken(requireActivity())
                        val refreshToken = nhnOAuthLoginModule.getRefreshToken(requireActivity())
                        val expiresAt = nhnOAuthLoginModule.getExpiresAt(requireActivity())
                        val tokenType = nhnOAuthLoginModule.getTokenType(requireActivity())
                        Log.i("TAG", "nhn Login Access Token : $accessToken")
                        Log.i("TAG", "nhn Login refresh Token : $refreshToken")
                        Log.i("TAG", "nhn Login expiresAt : $expiresAt")
                        Log.i("TAG", "nhn Login Token Type : $tokenType")
                        Log.i(
                            "TAG",
                            "nhn Login Module State : " + nhnOAuthLoginModule.getState(requireActivity()).toString()
                        )

                        //유저정보 가져오기
                        val task = NaverProfileTask()
                        task.execute(accessToken)

                        successLogin()
                    } else {
                        val errorCode =
                            nhnOAuthLoginModule.getLastErrorCode(requireActivity()).getCode()
                        val errorDesc = nhnOAuthLoginModule.getLastErrorDesc(requireActivity())
                        Toast.makeText(
                            requireActivity(),
                            "errorCode:$errorCode, errorDesc:$errorDesc",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
            )
        }

    }

    inner class RequestNHNLoginApiTask : AsyncTask<Void, Void, String>() {


        override fun onPostExecute(result: String?) {
            Log.d("TAG", "onPreExecute : $result")
            val startToken = "<message>"
            val endToken = "</message>"
            val startIndex = result?.indexOf(startToken) ?: -1
            val endIndex = result?.indexOf(endToken) ?: -1
            if (startIndex == -1 || endIndex <= 0) {
                return
            }
            val message = result?.substring(startIndex + startToken.length, endIndex)?.trim()
            if (message.equals("success")) {
                Log.d("TAG", "Success RequestNHNLoginApiTask")
                successLogin()
            } else {
                Log.e("TAG", "Login Fail")
            }
        }

        override fun doInBackground(vararg params: Void?): String {
            val url = "https://apis.naver.com/nidlogin/nid/getHashId_v2.xml"
            val at = nhnOAuthLoginModule.getAccessToken(requireActivity())
            Log.e("accesstoken",at)
            Log.e("TASIiK", nhnOAuthLoginModule.requestApi(requireActivity(), at, url))


            return nhnOAuthLoginModule.requestApi(requireActivity(), at, url)
        }

        override fun onPreExecute() {

        }
    }

    //유저 정보 가져오기
    inner class NaverProfileTask : AsyncTask<String, Void, String>() {


        override fun doInBackground(vararg params: String?): String? {

            var result: String? = null

            Log.e("UserInfo","testeststest")


            val token = nhnOAuthLoginModule.getAccessToken(requireActivity())// 네이버 로그인 접근 토큰;
            val header = "Bearer $token" // Bearer 다음에 공백 추가
            try {
                val apiURL = "https://openapi.naver.com/v1/nid/me"
                val url = URL(apiURL)
                val con = url.openConnection() as HttpURLConnection
                con.requestMethod = "GET"
                con.setRequestProperty("Authorization", header)
                val responseCode = con.responseCode
                val br: BufferedReader
                br = if (responseCode == 200) {
                    BufferedReader(InputStreamReader(con.inputStream))
                } else {
                    BufferedReader(InputStreamReader(con.errorStream))
                }

                var inputLine: String?
                val response = StringBuffer()
                inputLine = br.readLine()
                while(true) {
                    if(inputLine != null) {
                        response.append(inputLine)
                        inputLine = br.readLine()
                    } else
                        break
                }

                result = response.toString()
                br.close()
                Log.e("tagggggg",response.toString())
            } catch (e: Exception) {
                Log.e("tagaaaaa",e.toString())
            }

            //result 값은 JSONObject 형태
            return result

        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            try {
                val jsonObject = JSONObject(result)
                Log.d("TAG", "결과 : $result")
                if (jsonObject.getString("resultcode") == "00") {
                    val jsonObject = JSONObject(jsonObject.getString("response"))
                    val email = jsonObject.getString("id")
                    Log.d("jsonObject", jsonObject.toString())
                    Log.e("EMAIL", email)

                    /*
                    SharedPreferences.Editor editor = activity.userData.edit();
                    editor.putString("email", jsonObject.getString("email"));
                    editor.putString("name", jsonObject.getString("name"));
                    editor.putString("nickname", jsonObject.getString("nickname"));
                    editor.putString("profile", jsonObject.getString("profile_image"));
                    editor.apply();
                    Intent intent = new Intent(activity, MainActivity.class);
                    activity.startActivity(intent);
                     */
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }

        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(SignInViewModel::class.java)
        // TODO: Use the ViewModel
    }
}

