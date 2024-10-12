package com.nudriin.mylivedata

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.nudriin.mylivedata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MyViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[MyViewModel::class.java]

        subscribe()
    }

    private fun subscribe() {
        // Create Observer
        val elapsedTimeObserver = Observer<Long?> {
            val newText = this@MainActivity.resources.getString(R.string.seconds, it)
            binding.timerTextview.text = newText
        }

        viewModel.getElapsedTime().observe(this, elapsedTimeObserver)
    }
}