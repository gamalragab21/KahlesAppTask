package net.gamal.kahlesapptask.core.common.domain.repository.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import net.gamal.kahlesapptask.features.getPosts.data.models.entity.PostEntity

@Dao
internal interface PostsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllPosts(posts: List<PostEntity>)

    @Query("SELECT * FROM PostEntity ORDER BY id ASC")
    suspend fun getAll(): List<PostEntity>
}