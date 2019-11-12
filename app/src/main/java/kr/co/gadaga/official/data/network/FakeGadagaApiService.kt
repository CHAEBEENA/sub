package kr.co.gadaga.official.data.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.POST

private const val GADAGA_API_SERVICE_BASE_URL = "gadaga.com"

interface FakeGadagaApiService {

    @POST("register")
    fun pedestrian (

    )

    companion object {

        operator fun invoke(): SktMapsApiService {
            val okHttpClient = OkHttpClient.Builder().build()

            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(GADAGA_API_SERVICE_BASE_URL)
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(SktMapsApiService::class.java)
        }
    }
}