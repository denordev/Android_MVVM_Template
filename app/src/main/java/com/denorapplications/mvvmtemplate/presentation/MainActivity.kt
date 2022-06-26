package com.denorapplications.mvvmtemplate.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.denorapplications.mvvmtemplate.appComponent
import com.denorapplications.mvvmtemplate.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        appComponent.inject(this)
    }
}