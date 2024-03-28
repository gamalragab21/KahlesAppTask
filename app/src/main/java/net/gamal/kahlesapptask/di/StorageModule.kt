package net.gamal.kahlesapptask.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import net.gamal.kahlesapptask.core.common.data.consts.Constants
import net.gamal.kahlesapptask.core.common.data.repository.local.room.PostsDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object StorageModule {


    @Provides
    @Singleton
    fun providePetFinderDatabase(@ApplicationContext context: Context): PostsDatabase =
        Room.databaseBuilder(context, PostsDatabase::class.java, Constants.POSTS_DB_NAME)
            .build()
}