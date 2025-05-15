package com.example.shoes.data.local

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import java.io.IOException

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "user_settings")

class localStorage(private val context: Context) {
    private companion object {
        val AUTH_TOKEN_KEY = stringPreferencesKey("auth_token_key")
    }

    val tokenFlow: Flow<String> = context.dataStore.data
        .catch { e ->
            if (e is IOException) {
                emit(emptyPreferences())
            } else {
                throw e
            }
        }
        .map { prefs ->
            prefs[AUTH_TOKEN_KEY] ?: ""
        }

    suspend fun setToken(token: String) {
        context.dataStore.edit { prefs ->
            prefs[AUTH_TOKEN_KEY] = token
        }
    }

    suspend fun getToken(): String {
        return context.dataStore.data
            .catch { e ->
                if (e is IOException) emit(emptyPreferences())
                else throw e
            }
            .map { it[AUTH_TOKEN_KEY] ?: "" }
            .first()
    }
}