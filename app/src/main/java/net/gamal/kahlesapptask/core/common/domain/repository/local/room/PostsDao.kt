package net.gamal.kahlesapptask.core.common.domain.repository.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy

@Dao
internal interface PostsDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAllPosts(animals: List<PostEntity>)
}