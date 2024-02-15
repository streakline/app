package com.example.todolist.presentation.di

import android.content.Context
import java.time.LocalDate

object StreakManager {
    public var counter: Int = 0
    private var lastIncrementDay: LocalDate? = null

    fun incrementStreak() {
        val today = LocalDate.now()
        if (lastIncrementDay == null || !lastIncrementDay!!.isEqual(today)) {
            counter++
            lastIncrementDay = today
        }
    }

    fun getStreak(): Int = counter
}
