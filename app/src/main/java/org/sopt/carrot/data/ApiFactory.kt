package org.sopt.carrot.data

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.sopt.carrot.BuildConfig
import org.sopt.carrot.data.service.DummyService
import org.sopt.carrot.data.service.ProductApiService
import org.sopt.carrot.data.service.SearchService
import org.sopt.carrot.data.service.UserService
import retrofit2.Retrofit

object ApiFactory {
    private const val BASE_URL: String = BuildConfig.BASE_URL

    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val client = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()

    val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .build()
    }

    inline fun <reified T> create(): T = retrofit.create(T::class.java)
}

object ServicePool {
    val dummyService by lazy { ApiFactory.create<DummyService>() }
    val searchService by lazy { ApiFactory.create<SearchService>() }
    val productService by lazy { ApiFactory.create<ProductApiService>() }
    val userService by lazy { ApiFactory.create<UserService>() }
}
