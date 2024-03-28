package net.gamal.kahlesapptask.features.getPosts.data.repository

import net.gamal.kahlesapptask.features.getPosts.data.mapper.PostMapper
import net.gamal.kahlesapptask.features.getPosts.domain.models.Post
import net.gamal.kahlesapptask.features.getPosts.domain.repository.IGetPostsRepository
import net.gamal.kahlesapptask.features.getPosts.domain.repository.local.IGetPostsLocalDs
import net.gamal.kahlesapptask.features.getPosts.domain.repository.remote.IGetPostsRemoteDs
import javax.inject.Inject

internal class GetPostsRepository @Inject constructor(
    private val localDs: IGetPostsLocalDs, private val remoteDs: IGetPostsRemoteDs,
) : IGetPostsRepository {
    override suspend fun getPostsFromRemote(): List<Post> {
        val result = remoteDs.getPosts()
        return PostMapper.dtoToDomain(result)
    }

    override suspend fun getPostsFromLocal(): List<Post> {
        val result = localDs.getPosts()
        return PostMapper.entityToDomain(result)
    }

    override suspend fun savePosts(posts: List<Post>) {
        val entities = PostMapper.domainToEntity(posts)
        localDs.insertAnimals(entities)
    }
}