package net.gamal.kahlesapptask.core.common.data.repository.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import net.gamal.kahlesapptask.core.common.domain.repository.local.room.PostsDao
import net.gamal.kahlesapptask.features.getPosts.data.models.entity.PostEntity

@Database(entities = [PostEntity::class], version = 1)
internal abstract class PostsDatabase : RoomDatabase() {
    abstract fun postsDao(): PostsDao
}
