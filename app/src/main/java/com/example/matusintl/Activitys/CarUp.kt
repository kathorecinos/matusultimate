package com.example.matusintl.Activitys

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.matusintl.databinding.ActivityCarUpBinding
import org.json.JSONObject
import java.net.HttpURLConnection
import java.net.URL

lateinit var binding: ActivityCarUpBinding

class carUp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCarUpBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.imageButton.setOnClickListener {
            startActivity(Intent(this@carUp, Find::class.java))
        }


        Thread(Runnable {
            var url = URL("https://matus.b4a.io/classes/CARS")
            var urlConnection = url.openConnection() as HttpURLConnection
            urlConnection.setRequestProperty(
                "X-Parse-Application-Id",
                "TxxlvDcrIOtCJR6MFGPDHx1xkTvbYDTQOYvxpI0s"
            ) // This is the fake app's application id
            urlConnection.setRequestProperty(
                "X-Parse-Master-Key",
                "g2Y8rwpP3uGNhpdKANvW5wRAzuPoMXekc87KJZtO"
            ) // This is the fake app's readonly master key
            try {
                val data = JSONObject(
                    urlConnection.inputStream.bufferedReader()
                        .use { it.readText() }) // Here you have the data that you need
                Log.d("CarUp", data.toString(2))
            } catch (e: Exception) {
                Log.e("CarUp", e.toString())
            } finally {
                urlConnection.disconnect()
            }
        }).start()
    }


}
