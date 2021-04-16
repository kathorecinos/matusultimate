package com.example.matusintl

import android.app.Activity
import android.os.Bundle
import com.example.matusintl.databinding.ActivityUser2Binding


lateinit var binding: ActivityUser2Binding


class UserActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUser2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


    }
}