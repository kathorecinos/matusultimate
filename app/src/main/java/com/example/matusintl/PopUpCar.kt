package com.example.matusintl

import Activitys.Find
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.matusintl.databinding.ActivityPopUpCarBinding

private lateinit var binding: ActivityPopUpCarBinding

class PopUpCar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPopUpCarBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        binding.mapButton.setOnClickListener {
            val intent = Intent(this, Find::class.java)
            startActivity(intent)
        }

    }


}