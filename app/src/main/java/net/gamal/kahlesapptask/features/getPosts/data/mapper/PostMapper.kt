package net.gamal.kahlesapptask.features.getPosts.data.mapper

import net.gamal.kahlesapptask.core.common.data.mapper.Mapper
import net.gamal.kahlesapptask.features.getPosts.data.models.dto.PostDTO
import net.gamal.kahlesapptask.features.getPosts.data.models.entity.PostEntity
import net.gamal.kahlesapptask.features.getPosts.domain.models.Post

internal object PostMapper : Mapper<PostDTO, Post, PostEntity>() {
    override fun dtoToDomain(dto: PostDTO): Post = with(dto) {
        return@with Post(body, id, title, userId)
    }

    override fun domainToEntity(domain: Post): PostEntity = with(domain) {
        return@with PostEntity(body, id, title, userId)
    }

    override fun entityToDomain(entity: PostEntity)= with(entity) {
        return@with Post(body, id, title, userId)
    }
}