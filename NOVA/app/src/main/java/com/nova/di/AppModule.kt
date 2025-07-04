package com.nova.di
import android.content.Context
import androidx.room.Room
import com.nova.core.UserPreferences
import com.nova.data.NovaDatabase
import com.nova.services.NovaTtsEngine
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
@Module
@InstallIn(SingletonComponent::class)
object AppModule{
    @Provides @Singleton
    fun db(@ApplicationContext c:Context)=
        Room.databaseBuilder(c, NovaDatabase::class.java, "nova.db").build()
    @Provides fun dao(db:NovaDatabase)= db.taskDao()
    @Provides @Singleton fun prefs(@ApplicationContext c:Context)= UserPreferences(c)
    @Provides @Singleton fun tts(@ApplicationContext c:Context)= NovaTtsEngine(c)
}