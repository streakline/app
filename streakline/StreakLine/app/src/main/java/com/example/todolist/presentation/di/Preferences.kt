package com.example.todolist.presentation.di

import android.content.Context
import android.content.SharedPreferences

class Preferences(context: Context) {
    companion object{
        const val PREFS_NAME = "StreakDatabase"
        const val STREAK = "my_streak"
    }

    val prefs:SharedPreferences = context.getSharedPreferences(PREFS_NAME, 0)

    fun saveInformation(streak:Int){
        prefs.edit().putInt(STREAK, streak).apply()
    }

    fun getInformation(): Int {
        return prefs.getInt(STREAK, 0)
    }
}