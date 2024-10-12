package com.nudriin.mylivedata

import android.os.SystemClock
import androidx.lifecycle.ViewModel
import java.util.Timer
import java.util.TimerTask

class MyViewModel: ViewModel() {
    companion object {
        private const val ONE_SECOND = 1000
    }

    private val mInitialTime = SystemClock.elapsedRealtime()

    // Create timer
    init {
        val timer = Timer()
        timer.scheduleAtFixedRate(object : TimerTask() {
            override fun run() {
                val newValue = (SystemClock.elapsedRealtime() - mInitialTime) / 1000
            }
        }, ONE_SECOND.toLong(), ONE_SECOND.toLong())
    }

}