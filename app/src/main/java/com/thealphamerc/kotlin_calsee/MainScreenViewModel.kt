package com.thealphamerc.kotlin_calsee

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainScreenViewModel : ViewModel() {

    init {
        Log.d("ViewModel: ", "init")
    }

    private val _numericValue = MutableLiveData<String?>()

    val numericValue: LiveData<String?>
        get() = _numericValue

    fun onNoTap(no: Int) {

        Log.d("ViewModel: ", no.toString())
//        _numericValue.value = _numericValue.value  + no.toString()
    }

    fun onAirthmaticSymbolTap(symbol: String) {

        Log.d("ViewModel: ", symbol)
    }

    fun onDeletenoTap() {}

    fun onDecimalnoTap() {}


    fun onclearRsult() {

    }

    fun onCalculateResult() {

    }


    override fun onCleared() {
        Log.d("ViewModel: ", "On Cleared")
        super.onCleared()
    }
}
