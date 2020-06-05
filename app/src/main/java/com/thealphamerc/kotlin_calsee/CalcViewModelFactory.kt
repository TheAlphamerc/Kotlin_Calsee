package com.thealphamerc.kotlin_calsee

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class CalcViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainScreenViewModel::class.java)) {
            return MainScreenViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}