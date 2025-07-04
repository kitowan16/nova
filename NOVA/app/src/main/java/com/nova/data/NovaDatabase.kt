package com.nova.data
import androidx.room.Database
import androidx.room.RoomDatabase
@Database(entities=[Task::class], version=1)
abstract class NovaDatabase:RoomDatabase(){
    abstract fun taskDao():TaskDao
}