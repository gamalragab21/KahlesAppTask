package net.gamal.kahlesapptask.features.getPosts.domain.repository

import net.gamal.kahlesapptask.features.getPosts.domain.models.Post

interface IGetPostsRepository {
    suspend fun getPostsFromRemote(): List<Post>
    suspend fun getPostsFromLocal(): List<Post>
    suspend fun savePosts(posts: List<Post>)
}