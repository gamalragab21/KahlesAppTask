package net.gamal.kahlesapptask.features.getPosts.domain.interactor

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import net.gamal.kahlesapptask.core.common.domain.interactor.UseCaseLocalThenRemoteThenCache
import net.gamal.kahlesapptask.features.getPosts.domain.models.Post
import net.gamal.kahlesapptask.features.getPosts.domain.repository.IGetPostsRepository
import javax.inject.Inject

class GetPosts @Inject constructor(private val repository: IGetPostsRepository) :
    UseCaseLocalThenRemoteThenCache<List<Post>, Unit>() {
    override fun executeLocalDS(body: Unit?): Flow<List<Post>> = flow {
//        if (body == null || body.isInitialState())
//            throw LeonException.Local.RequestValidation(CategoryList<Post>Request::class)
//        body.validateRequestContract().also {
        emit(repository.getPostsFromLocal())
//        }
    }

    override fun performRemoteOperation(domain: List<Post>?): Boolean = domain?.isEmpty() == true

    override fun executeRemoteDS(body: Unit?): Flow<List<Post>> = flow {
        emit(repository.getPostsFromRemote())
    }

    override fun performLocalOperation(domain: List<Post>): Boolean = domain.isNotEmpty()

    override suspend fun executeLocalOperation(domain: List<Post>, body: Unit?) {
        repository.savePosts(domain)
    }
}