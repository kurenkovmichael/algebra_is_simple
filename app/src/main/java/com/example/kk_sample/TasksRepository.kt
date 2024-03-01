package com.example.kk_sample

import android.content.res.Resources
import android.util.Log
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.serialization.json.Json
import java.lang.String

private const val TAG = "MyActivity"

class TasksRepository(val resources: Resources) {

    val topics: StateFlow<List<Topic>> get() = mutableTopics
    private val mutableTopics = MutableStateFlow<List<Topic>>(listOf())

    fun loadTopics() {
        try {
            val dataJson = readRawResource(id = R.raw.data)
            val data = Json.decodeFromString<Topics>(dataJson)
            mutableTopics.value = data.topics
        } catch (e: Throwable) {
            Log.e(TAG, "Failed loading topics with error ${e.message}")
        }
    }

    @Throws(Exception::class)
    private fun readRawResource(id: Int): kotlin.String {
        val stream = resources.openRawResource(id)
        val bytes = ByteArray(stream.available())
        stream.read(bytes)
        return String(bytes).toString()
    }

}
