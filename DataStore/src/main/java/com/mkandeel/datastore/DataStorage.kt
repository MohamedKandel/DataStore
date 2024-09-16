package com.mkandeel.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.byteArrayPreferencesKey
import androidx.datastore.preferences.core.doublePreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.floatPreferencesKey
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.longPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.core.stringSetPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first

class DataStorage private constructor(context: Context, name: String = context.packageName) {

    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name)

    companion object {
        private var dataStorage: DataStorage? = null

        fun getInstance(context: Context, name: String = context.packageName): DataStorage {
            if (dataStorage == null) {
                dataStorage = DataStorage(context, name)
            }
            return dataStorage as DataStorage
        }

    }

    private suspend fun <T> get(context: Context, key: Preferences.Key<T>): T? {
        val prefs = context.dataStore.data.first()
        return prefs[key]
    }

    private suspend fun <T> remove(context: Context, key: Preferences.Key<T>) {
        context.dataStore.edit {
            it.remove(key)
        }
    }

    suspend fun putString(context: Context, key: String, value: String) {
        val dataStoreKey = stringPreferencesKey(key)
        context.dataStore.edit {
            it[dataStoreKey] = value
        }
    }

    suspend fun getString(context: Context, key: String): String? {
        val dataStoreKey = stringPreferencesKey(key)
        return get(context, dataStoreKey)
    }

    suspend fun removeStringValue(context: Context, key: String) {
        val dataStoreKey = stringPreferencesKey(key)
        remove(context, dataStoreKey)
    }

    suspend fun putBoolean(context: Context, key: String, value: Boolean) {
        val dataStoreKey = booleanPreferencesKey(key)
        context.dataStore.edit {
            it[dataStoreKey] = value
        }
    }

    suspend fun getBoolean(context: Context, key: String): Boolean? {
        val dataStoreKey = booleanPreferencesKey(key)
        return get(context, dataStoreKey)
    }

    suspend fun removeBooleanValue(context: Context, key: String) {
        val dataStoreKey = booleanPreferencesKey(key)
        remove(context, dataStoreKey)
    }

    suspend fun putInt(context: Context, key: String, value: Int) {
        val dataStoreKey = intPreferencesKey(key)
        context.dataStore.edit {
            it[dataStoreKey] = value
        }
    }

    suspend fun getInt(context: Context, key: String): Int? {
        val dataStoreKey = intPreferencesKey(key)
        return get(context, dataStoreKey)
    }

    suspend fun removeIntValue(context: Context, key: String) {
        val dataStoreKey = intPreferencesKey(key)
        remove(context,dataStoreKey)
    }

    suspend fun putDouble(context: Context, key: String, value: Double) {
        val dataStoreKey = doublePreferencesKey(key)
        context.dataStore.edit {
            it[dataStoreKey] = value
        }
    }

    suspend fun getDouble(context: Context, key: String): Double? {
        val dataStoreKey = doublePreferencesKey(key)
        return get(context, dataStoreKey)
    }

    suspend fun removeDoubleValue(context: Context, key: String) {
        val dataStoreKey = doublePreferencesKey(key)
        remove(context,dataStoreKey)
    }

    suspend fun putFloat(context: Context, key: String, value: Float) {
        val dataStoreKey = floatPreferencesKey(key)
        context.dataStore.edit {
            it[dataStoreKey] = value
        }
    }

    suspend fun getFloat(context: Context, key: String): Float? {
        val dataStoreKey = floatPreferencesKey(key)
        return get(context, dataStoreKey)
    }

    suspend fun removeFloatValue(context: Context, key: String) {
        val dataStoreKey = floatPreferencesKey(key)
        remove(context, dataStoreKey)
    }

    suspend fun putLong(context: Context, key: String, value: Long) {
        val dataStoreKey = longPreferencesKey(key)
        context.dataStore.edit {
            it[dataStoreKey] = value
        }
    }

    suspend fun getLong(context: Context, key: String): Long? {
        val dataStoreKey = longPreferencesKey(key)
        return get(context, dataStoreKey)
    }

    suspend fun removeLongValue(context: Context, key: String) {
        val dataStoreKey = longPreferencesKey(key)
        remove(context, dataStoreKey)
    }

    suspend fun putByteArray(context: Context, key: String, value: ByteArray) {
        val dataStoreKey = byteArrayPreferencesKey(key)
        context.dataStore.edit {
            it[dataStoreKey] = value
        }
    }

    suspend fun getByteArray(context: Context, key: String): ByteArray? {
        val dataStoreKey = byteArrayPreferencesKey(key)
        return get(context, dataStoreKey)
    }

    suspend fun removeByteArrayValue(context: Context, key: String) {
        val dataStoreKey = byteArrayPreferencesKey(key)
        remove(context, dataStoreKey)
    }

    suspend fun putStringSet(context: Context, key: String, value: Set<String>) {
        val dataStoreKey = stringSetPreferencesKey(key)
        context.dataStore.edit {
            it[dataStoreKey] = value
        }
    }

    suspend fun getStringSet(context: Context, key: String): Set<String>? {
        val dataStoreKey = stringSetPreferencesKey(key)
        return get(context, dataStoreKey)
    }

    suspend fun removeStringSetValue(context: Context, key: String) {
        val dataStoreKey = stringSetPreferencesKey(key)
        remove(context, dataStoreKey)
    }

    suspend fun clearAll(context: Context) {
        context.dataStore.edit {
            it.clear()
        }
    }
}