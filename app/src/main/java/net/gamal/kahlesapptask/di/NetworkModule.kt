package net.gamal.kahlesapptask.di

import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import net.gamal.kahlesapptask.BuildConfig
import net.gamal.kahlesapptask.android.helpers.properties.domain.IConfigurationUtil
import net.gamal.kahlesapptask.core.common.data.repository.remote.PostsApiService
import net.gamal.kahlesapptask.core.common.data.repository.remote.RetrofitNetworkProvider
import net.gamal.kahlesapptask.core.common.data.repository.remote.converter.ResponseBodyConverter
import net.gamal.kahlesapptask.core.common.data.repository.remote.factory.LeonCallAdapterFactory
import net.gamal.kahlesapptask.core.common.domain.repository.remote.INetworkProvider
import okhttp3.ConnectionPool
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object NetworkModule {

    @Provides
    @Singleton
    fun providePetFinderApiService(retrofit: Retrofit): PostsApiService =
        retrofit.create(PostsApiService::class.java)

    @Provides
    @Singleton
    fun provideRetrofitNetwork(petFinderApiService: PostsApiService): INetworkProvider =
        RetrofitNetworkProvider(petFinderApiService)

    @Provides
    @Singleton
    fun provideRetrofit(
        gsonFactory: GsonConverterFactory,
        okHttpClient: OkHttpClient.Builder,
        configurationUtil: IConfigurationUtil,
    ): Retrofit =
        Retrofit.Builder().client(okHttpClient.build())
            .baseUrl(configurationUtil.getServerBaseUrl())
            .addConverterFactory(gsonFactory)
            .addCallAdapterFactory(LeonCallAdapterFactory.create(ResponseBodyConverter())).build()

    @Provides
    @Singleton
    fun provideGsonFactory(): GsonConverterFactory =
        GsonConverterFactory.create(GsonBuilder().create())

    @Provides
    @Singleton
    fun provideOkHttpClient(
        interceptor: HttpLoggingInterceptor,
    ) = OkHttpClient().newBuilder().apply {
        connectTimeout(30L, TimeUnit.SECONDS)
        retryOnConnectionFailure(true)
        connectionPool(
            ConnectionPool(30L.toInt(), 500000, TimeUnit.MILLISECONDS)
        )
        readTimeout(30L, TimeUnit.SECONDS)
        writeTimeout(30L, TimeUnit.SECONDS)
        addInterceptor(interceptor)
    }

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
            else HttpLoggingInterceptor.Level.NONE
        }
}