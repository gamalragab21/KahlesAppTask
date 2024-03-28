package net.soft.features.getPetByCategoryUC.data.repository.remote

import net.gamal.kahlesapptask.core.common.domain.repository.remote.INetworkProvider
import net.gamal.kahlesapptask.features.getPosts.data.models.dto.PostsDTO
import net.gamal.kahlesapptask.features.getPosts.domain.repository.remote.IGetPostsRemoteDs
import javax.inject.Inject

internal class GetPostsRemoteDs @Inject constructor(private val networkProvider: INetworkProvider) :
    IGetPostsRemoteDs {
    override suspend fun getPosts(): PostsDTO {
        return networkProvider.get(
            PostsDTO::class.java,
            pathUrl = POSTS,
        )
    }

    companion object {
        const val POSTS = "posts"
    }
}