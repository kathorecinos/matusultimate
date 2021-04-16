package com.example.matusintl.Activitys

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.matusintl.databinding.ActivityDataSendBinding

class dataSendActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDataSendBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDataSendBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        supportActionBar?.hide()

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this@dataSendActivity, main::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }
}