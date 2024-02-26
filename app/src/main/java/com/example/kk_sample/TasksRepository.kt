package com.example.kk_sample

import android.content.res.Resources
import kotlinx.serialization.json.Json
import java.lang.Exception
import java.lang.String

class TasksRepository(val resources: Resources) {

    fun loadTopics(): List<Topic> {
        return try {
            val dataJson = readRawResource(id = R.raw.data)
            val data = Json.decodeFromString<Topics>(dataJson)
            data.topics
        } catch (e: Throwable) {
            listOf()
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
