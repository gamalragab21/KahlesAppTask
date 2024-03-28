package net.gamal.kahlesapptask.features.getPosts.data.models.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PostEntity(
    var body: String,
    @PrimaryKey
    var id: Int,
    var title: String,
    var userId: Int
)