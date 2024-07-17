package com.gojek.daggersubcomponents.data

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NameDataSource @Inject constructor() {
    fun getRandomName(): String {
        val names = listOf("Abdul", "Hafiz", "Ramadan")
        return names.random()
    }
}