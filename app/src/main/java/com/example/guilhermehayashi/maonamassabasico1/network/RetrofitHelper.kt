package com.example.guilhermehayashi.maonamassabasico1.network

import android.util.Log
import com.example.guilhermehayashi.maonamassabasico1.BuildConfig
import com.example.guilhermehayashi.maonamassabasico1.LoginActivity
import com.example.guilhermehayashi.maonamassabasico1.MainActivity
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {

    private var retrofit: Retrofit? = null
    private var useAuth = true

    fun getRetrofit(useAuth: Boolean = true): Retrofit? {
        if (retrofit == null || this.useAuth != useAuth) {
            this.useAuth = useAuth
            rebuildRetrofit()
        }
        return retrofit
    }

    private fun rebuildRetrofit() {
        val client = buildClient()
        retrofit = Retrofit.Builder()
                .baseUrl(Api.url)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(buildGson()))
                .client(client)
                .build()
    }

    private fun buildClient(): OkHttpClient {
        val builder = OkHttpClient.Builder()
        addLoggingInterceptor(builder)
        if (useAuth) {
            addTokenInterceptor(builder)
        }
        return builder.build()
    }

    private fun addLoggingInterceptor(builder: OkHttpClient.Builder) {
        if (BuildConfig.DEBUG) {
            val httpLoggingInterceptor = HttpLoggingInterceptor { message -> Log.d("HttpLoggingInterceptor", message) }
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            builder.addNetworkInterceptor(httpLoggingInterceptor)
        }
    }

    private fun addTokenInterceptor(builder: OkHttpClient.Builder): OkHttpClient.Builder {
        val tokenInterceptor = Interceptor { chain ->
            var newRequest = chain.request()
            val accessToken = Api.userToken
            newRequest = newRequest.newBuilder().addHeader("Authorization", "Token $accessToken").build()
            chain.proceed(newRequest)
        }
        builder.addNetworkInterceptor(tokenInterceptor)
        return builder
    }

    private fun buildGson(): Gson {
        return GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create()
    }
}