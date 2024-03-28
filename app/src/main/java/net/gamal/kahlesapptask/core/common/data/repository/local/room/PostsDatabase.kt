package net.gamal.kahlesapptask.core.common.data.repository.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import net.gamal.kahlesapptask.core.common.domain.repository.local.room.PostsDao

@Database(entities = [PostEntity::class], version = 1)
internal abstract class PostsDatabase : RoomDatabase() {
    abstract fun postsDao(): PostsDao
}
