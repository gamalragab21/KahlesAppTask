package net.gamal.kahlesapptask.features.getPosts.domain.repository.remote

import net.gamal.kahlesapptask.features.getPosts.data.models.dto.PostsDTO


internal interface IGetPostsRemoteDs {

    suspend fun getPosts(): PostsDTO
}