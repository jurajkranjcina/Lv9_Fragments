package com.example.lv9_fragments

import java.util.*

data class Work (val id: UUID = UUID.randomUUID(), var title: String="",
var date: Date = Date(), var isDone: Boolean = false) {
}