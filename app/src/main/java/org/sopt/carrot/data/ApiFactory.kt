package org.sopt.carrot.data

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.json.JSONArray
import org.json.JSONObject
import org.sopt.carrot.BuildConfig
import org.sopt.carrot.core.extension.isJsonArray
import org.sopt.carrot.core.extension.isJsonObject
import org.sopt.carrot.data.service.CategoryService
import org.sopt.carrot.data.service.DummyService
import org.sopt.carrot.data.service.HomeService
import org.sopt.carrot.data.service.ProductService
import org.sopt.carrot.data.service.SearchService
import org.sopt.carrot.data.service.UserService
import retrofit2.Converter
import retrofit2.Retrofit
import timber.log.Timber

object ApiFactory {
    private const val BASE_URL: String = BuildConfig.BASE_URL
    private const val OKHTTP = "okhttp"
    private const val UNIT_TAB = 4

    private val json = Json {
        ignoreUnknownKeys = true
        prettyPrint = true
    }

    private val jsonConverter: Converter.Factory =
        json.asConverterFactory("application/json".toMediaType())

    private val loggingInterceptor: Interceptor = HttpLoggingInterceptor { message ->
        when {
            message.isJsonObject() -> Timber.tag(OKHTTP).d(JSONObject(message).toString(UNIT_TAB))
            message.isJsonArray() -> Timber.tag(OKHTTP).d(JSONArray(message).toString(UNIT_TAB))
            else -> Timber.tag(OKHTTP).d("CONNECTION INFO -> $message")
        }
    }.apply {
        level =
            if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
    }

    private val client = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()

    val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(jsonConverter)
            .build()
    }

    inline fun <reified T> create(): T = retrofit.create(T::class.java)
}

object ServicePool {
    val dummyService by lazy { ApiFactory.create<DummyService>() }
    val searchService by lazy { ApiFactory.create<SearchService>() }
    val categoryService by lazy { ApiFactory.create<CategoryService>() }
    val productService by lazy { ApiFactory.create<ProductService>() }
    val userService by lazy { ApiFactory.create<UserService>() }
    val homeService by lazy { ApiFactory.create<HomeService>() }

}
