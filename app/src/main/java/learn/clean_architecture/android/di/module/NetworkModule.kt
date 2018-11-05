package learn.clean_architecture.android.di.module

import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import learn.clean_architecture.android.BuildConfig
import learn.clean_architecture.android.MainApp
import learn.clean_architecture.android.data.network.services.SportDbServices
import learn.clean_architecture.android.di.scope.AppScope
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit
import javax.inject.Named

/**
 * Created by Yoga C. Pranata on 05/11/2018.
 * Android Engineer
 */
@Module
class NetworkModule (val mainApp: MainApp) {
    @Provides
    @AppScope
    fun provideOkhttpClient(): OkHttpClient {
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

    @Provides
    @AppScope
    @Named("tsdb_rest")
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

    @Provides
    @AppScope
    fun provideSportDbServices(@Named("tsdb_rest") restAdapter: Retrofit): SportDbServices {
        return restAdapter.create<SportDbServices>(SportDbServices::class.java)
    }
}