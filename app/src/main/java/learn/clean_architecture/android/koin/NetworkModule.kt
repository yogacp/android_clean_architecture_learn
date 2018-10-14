package learn.clean_architecture.android.koin

import com.google.gson.GsonBuilder
import learn.clean_architecture.android.BuildConfig
import learn.clean_architecture.android.MainApp
import learn.clean_architecture.android.data.network.services.SportDbServices
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit

/**
 * Created by Yoga C. Pranata on 14/10/2018.
 * Android Engineer
 */
val networkModule = module {
    single { provideOkhttpClient(get()) }
    single { provideRestClient(get()) }
    single { provideSportDbServices(get()) }
}

fun provideOkhttpClient(mainApp: MainApp): OkHttpClient {
    val httpCacheDirectory = File(mainApp.cacheDir, "httpCache")
    val cache = Cache(httpCacheDirectory, 10 * 1024 * 1024)
    val loggingInterceptor = HttpLoggingInterceptor()
    loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

    return  OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .addInterceptor { chain ->
            try {
                chain.proceed(chain.request())
            } catch (e: Exception) {
                val offlineRequest = chain.request().newBuilder()
                    .header("Cache-Control", "public, only-if-cached," +
                            "max-stale=" + 60 * 60 * 24)
                    .build()
                chain.proceed(offlineRequest)
            }
        }
        .cache(cache)
        .writeTimeout(60, TimeUnit.SECONDS)
        .readTimeout(60, TimeUnit.SECONDS)
        .connectTimeout(60, TimeUnit.SECONDS)
        .build()
}

fun provideRestClient(okHttpClient: OkHttpClient): Retrofit {
    val builder = Retrofit.Builder()
    val gson = GsonBuilder()
        .setLenient()
        .create()
    builder.client(okHttpClient)
        .baseUrl(BuildConfig.BASE_URL)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create(gson))
    return builder.build()
}

fun provideSportDbServices(restAdapter: Retrofit): SportDbServices {
    return restAdapter.create<SportDbServices>(SportDbServices::class.java)
}