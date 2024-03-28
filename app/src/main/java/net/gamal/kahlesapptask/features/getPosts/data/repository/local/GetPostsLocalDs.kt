package net.gamal.kahlesapptask.features.getPosts.data.repository.local

import net.gamal.kahlesapptask.core.common.domain.repository.local.room.PostsDao
import net.gamal.kahlesapptask.features.getPosts.data.models.entity.PostEntity
import net.gamal.kahlesapptask.features.getPosts.domain.repository.local.IGetPostsLocalDs
import javax.inject.Inject

internal class GetPostsLocalDs @Inject constructor(private val dao: PostsDao) :
    IGetPostsLocalDs {
    override suspend fun insertAnimals(posts: List<PostEntity>) {
        dao.insertAllPosts(posts)
    }

    override suspend fun getPosts(): List<PostEntity> {
        return dao.getAll()
    }
}