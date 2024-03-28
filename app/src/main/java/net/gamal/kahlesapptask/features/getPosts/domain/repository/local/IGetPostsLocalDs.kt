package net.gamal.kahlesapptask.features.getPosts.domain.repository.local

import net.gamal.kahlesapptask.features.getPosts.data.models.entity.PostEntity

interface IGetPostsLocalDs {
    suspend fun insertAnimals(posts: List<PostEntity>)
    suspend fun getPosts(): List<PostEntity>
}