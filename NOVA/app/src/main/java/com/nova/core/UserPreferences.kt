package com.nova.core
import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first
class UserPreferences(private val context: Context){
    private val Context.dataStore by preferencesDataStore("nova_prefs")
    private val KEY = stringPreferencesKey("username")
    suspend fun save(name:String)=context.dataStore.edit{it[KEY]=name}
    suspend fun get()=context.dataStore.data.first()[KEY]
}