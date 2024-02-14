package com.example.todolist.presentation.di

import android.content.Context
import java.time.LocalDate

object StreakManager {
    private var counter: Int = 0
    private var lastIncrementDay: LocalDate? = null

    fun incrementStreak() {
        val today = LocalDate.now()
        if (lastIncrementDay == null || !lastIncrementDay!!.isEqual(today)) {
            counter++
            lastIncrementDay = today
        }
    }

    fun getStreak(): Int = counter

    // Add any additional methods you might need, like resetting the streak or saving/loading the streak data.

    fun saveStreak(context: Context) {
        val sharedPref = context.getSharedPreferences("StreakPrefs", Context.MODE_PRIVATE)
        with(sharedPref.edit()) {
            putInt("counter", counter)
            putString("lastIncrementDay", lastIncrementDay.toString())
            apply()
        }
    }

    fun loadStreak(context: Context) {
        val sharedPref = context.getSharedPreferences("StreakPrefs", Context.MODE_PRIVATE)
        counter = sharedPref.getInt("counter", 0)
        lastIncrementDay = LocalDate.parse(sharedPref.getString("lastIncrementDay", null))
    }
}
