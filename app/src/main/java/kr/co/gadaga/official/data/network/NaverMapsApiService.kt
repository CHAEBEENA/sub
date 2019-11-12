package kr.co.gadaga.official.data.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kr.co.gadaga.official.BuildConfig
import kr.co.gadaga.official.data.model.naver.GeocodeResponse
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface NaverMapsApiService {

    @GET("geocode")
    fun geocode (
        @Query("query") query: String,
        @Query("coordinates") coordinates: String, // 'lon,lat'
        @Query("page") page: Int = 1, // default
        @Query("count")count: Int = 10 // default 1~100
    ) : GeocodeResponse

    companion object {

        operator fun invoke(): NaverMapsApiService {
            /* request interceptor */
            val requestInterceptor = Interceptor { chain ->
                /* 요청 헤더 */
                val request = chain.request()
                    .newBuilder()
                    .addHeader("X-NCP-APIGW-API-KEY-ID", "yk7szpbi88")
                    .addHeader("X-NCP-APIGW-API-KEY", "PTiiZsfpjQZ8bS551t4rEwOnGeU5JxPll0yh07JC")
                    .build()

                return@Interceptor chain.proceed(request)
            }

            /* client TODO(connectivity interceptor 추가) */
            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(requestInterceptor)
                .build()

            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(BuildConfig.NAVER_MAPS_API_URL)
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(NaverMapsApiService::class.java)
        }
    }
}