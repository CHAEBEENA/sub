package kr.co.gadaga.official.data.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import kr.co.gadaga.official.BuildConfig
import kr.co.gadaga.official.data.model.skt.PedestrianResponse
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface SktMapsApiService {

    @GET("pedestrian")
    fun pedestrian (
        @Query("version") version: Int = 1,
        @Query("startX") startX: Double = 126.973851,
        @Query("startY") startY: Double = 37.565092,
        @Query("endX") endX: Double = 126.972771,
        @Query("endY") endY: Double = 37.559343,
        @Query("startName") startName: String = "%22%22", // empty utf-8 기반 URL 인코딩
        @Query("endName") endName: String = "%22%22",
        @Query("passList") passList: String = "126.984941,37.562218" // 경유지 126.92774822,37.55395475_126.92577620,37.55337145_
    ): Deferred<PedestrianResponse>

    companion object {

        operator fun invoke(): SktMapsApiService {
            /* request interceptor */
            val requestInterceptor = Interceptor { chain ->

                val url = chain.request()
                    .url()
                    .newBuilder()
                    .addQueryParameter("appKey", "9293daa1-6a00-4a59-bdb3-d788835af990")
                    .build()

                val request = chain.request()
                    .newBuilder()
                    .url(url)
                    .build()

                return@Interceptor chain.proceed(request)
            }

            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(requestInterceptor)
                .build()

            /* client TODO(connectivity interceptor 추가) */

            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(BuildConfig.SKT_MAPS_API_URL)
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(SktMapsApiService::class.java)
        }
    }
}