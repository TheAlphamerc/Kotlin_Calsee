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

    private val _expressionValue = MutableLiveData<String?>()
    val expressionValue: LiveData<String?>
        get() = _expressionValue

    fun onNoTap(no: Int) {

        Log.d("ViewModel: ", no.toString())
        if (_numericValue.value == null) {
            _numericValue.value = no.toString()
        } else {
            _numericValue.value = _numericValue.value + no.toString()
        }

    }

    fun onAirthmaticSymbolTap(symbol: String) {

        val st = _expressionValue.value ?: ""

        if (st.isNotEmpty()) {
            if (st.contains("+") || st.contains("-") || st.contains("*") || st.contains("/")) {
                _expressionValue.value = st.substring(0, st.length - 1) + symbol
            } else {
                _expressionValue.value = "$st $symbol"
            }

        } else {
            _expressionValue.value = _numericValue.value + " " + symbol
            _numericValue.value = ""
        }


    }

    fun onDeleteButtonTap() {
        val st = _numericValue.value ?: ""
        if (st.length > 1) {
            _numericValue.value = st.substring(0, st.length - 1)
        } else {
            _numericValue.value = ""
        }
    }

    fun onDecimalButtonTap() {
        val st = _numericValue.value ?: ""
        if (st.contains(".")) {
            return
        }
        if (_numericValue.value == null) {
            _numericValue.value = "."
        } else {
            _numericValue.value += "."
        }
    }


    fun onclearResult() {
        _numericValue.value = ""
        _expressionValue.value = ""
    }

    fun onCalculateResult() {
        try {
            val exp = _expressionValue.value ?: ""
            val b = _numericValue.value ?: ""


            if (exp.isEmpty() || b.isEmpty()) {
                return
            }
            Log.d("B: ", b.toString())
            Log.d("Exp: ", exp)


            val a = exp.substring(0, exp.length - 2)


            val symb = exp.substring(exp.length - 1, exp.length)

            Log.d("A: ", a.toString())
            Log.d("B: ", b.toString())
            Log.d("Symb: ", symb)

            val res = when (symb) {
                "+" -> a.toDouble() + b.toDouble()
                "-" -> a.toDouble() - b.toDouble()
                "*" -> a.toDouble() * b.toDouble()
                "/" -> a.toDouble() / b.toDouble()
                else -> ""
            }
            Log.d("Res: ", res.toString())
            _expressionValue.value = res.toString()
            _numericValue.value = ""
        } catch (e: Exception) {
            Log.e("OnCalculate", e.message)
        }


    }


    override fun onCleared() {
        Log.d("ViewModel: ", "On Cleared")
        super.onCleared()
    }
}
