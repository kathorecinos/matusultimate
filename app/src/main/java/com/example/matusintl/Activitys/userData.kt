package com.example.matusintl.Activitys

import android.app.Activity
import android.app.ProgressDialog
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.matusintl.databinding.ActivityUserDataBinding
import java.util.*
import kotlin.collections.HashMap


class userData : AppCompatActivity() {
    private lateinit var binding: ActivityUserDataBinding


    lateinit var filepath: Uri


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserDataBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)



        binding.buttonSave.setOnClickListener {
            val Nombre = binding.textInputName2.text.toString()
            val Importadora = binding.textInputImportadora2.text.toString()
            val Correo = binding.textInputMail2.text.toString()


            val url =
                "https://script.google.com/macros/s/AKfycbz2wKUv87zi3xWIHY9UZQa3pU9DWKcRLA9X1SP-0MX_jsC-wE90/exec"
            val stringRequest = object : StringRequest(com.android.volley.Request.Method.POST, url,
                Response.Listener {
                    Toast.makeText(this@userData, it.toString(), Toast.LENGTH_SHORT).show()
                },
                Response.ErrorListener {
                    Toast.makeText(this@userData, it.toString(), Toast.LENGTH_SHORT).show()
                }) {
                override fun getParams(): MutableMap<String, String> {
                    val params = HashMap<String, String>()
                    params["Nombre"] = binding.textInputName2.text.toString()
                    params["Importadora"] = binding.textInputImportadora2.text.toString()
                    params["Correo"] = binding.textInputMail2.text.toString()

                    return params
                }
            }
            val queue = Volley.newRequestQueue(this@userData)
            queue.add(stringRequest)

        }


    }


    private fun uploadFile() {
        if (filepath != null) {
            var pd = ProgressDialog(this)
            pd.setTitle("Uploading")
            pd.show()


        }
    }

    private fun startFileChooser() {
        var i = Intent()
        i.type = "image/*"
        i.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(Intent.createChooser(i, "Choose Picture"), 111)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 111 && resultCode == Activity.RESULT_OK && data != null) {
            filepath = data.data!!
            var bitmap: Bitmap = MediaStore.Images.Media.getBitmap(contentResolver, filepath)

        }
    }

}