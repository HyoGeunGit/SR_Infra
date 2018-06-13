package kr.co.highton.slacks.sim

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object Client {

        var retrofitService: API
        init {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            val logger = OkHttpClient.Builder().addInterceptor(interceptor).readTimeout(20, TimeUnit.SECONDS).writeTimeout(20, TimeUnit.SECONDS).build()

            val retrofit = Retrofit.Builder()
                    .baseUrl("http://58.145.101.15:3030")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(logger)
                    .build()

            retrofitService = retrofit.create(API::class.java)


        }
}

