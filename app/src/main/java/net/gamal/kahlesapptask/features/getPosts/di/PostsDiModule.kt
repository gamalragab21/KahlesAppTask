package net.soft.features.GetPostsUC.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import net.gamal.kahlesapptask.core.common.data.repository.local.room.PostsDatabase
import net.gamal.kahlesapptask.core.common.domain.repository.remote.INetworkProvider
import net.gamal.kahlesapptask.features.getPosts.data.repository.GetPostsRepository
import net.gamal.kahlesapptask.features.getPosts.data.repository.local.GetPostsLocalDs
import net.gamal.kahlesapptask.features.getPosts.domain.repository.IGetPostsRepository
import net.gamal.kahlesapptask.features.getPosts.domain.repository.local.IGetPostsLocalDs
import net.gamal.kahlesapptask.features.getPosts.domain.repository.remote.IGetPostsRemoteDs
import net.soft.features.getPetByCategoryUC.data.repository.remote.GetPostsRemoteDs
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object PostsDiModule {

    @Provides
    @Singleton
    fun provideGetPostsRemoteDs(provider: INetworkProvider): IGetPostsRemoteDs =
        GetPostsRemoteDs(provider)

    @Provides
    @Singleton
    fun provideGetPostsLocalDs(petFinderDatabase: PostsDatabase): IGetPostsLocalDs =
        GetPostsLocalDs(petFinderDatabase.postsDao())

    @Provides
    @Singleton
    fun provideGetPetRepository(
        localDs: IGetPostsLocalDs, remoteDs: IGetPostsRemoteDs,
    ): IGetPostsRepository = GetPostsRepository(localDs, remoteDs)
}