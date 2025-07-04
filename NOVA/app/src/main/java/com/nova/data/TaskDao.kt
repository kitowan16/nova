package com.nova.data
import androidx.room.*
import kotlinx.coroutines.flow.Flow
@Dao interface TaskDao{
    @Insert suspend fun insert(t:Task)
    @Query("SELECT * FROM Task") fun all():Flow<List<Task>>
}