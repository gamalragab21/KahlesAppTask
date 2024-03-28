package net.gamal.kahlesapptask.features.getPosts.domain.models

data class Post(
    var body: String,
    var id: Int,
    var title: String,
    var userId: Int,
)