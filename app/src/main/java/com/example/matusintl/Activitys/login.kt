package com.example.matusintl.Activitys

import android.app.AlertDialog
import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.matusintl.databinding.ActivityLoginBinding
import com.parse.ParseUser
import com.parse.SignUpCallback


class login : AppCompatActivity() {


    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        supportActionBar?.hide()


        binding.button2.setOnClickListener {
            val intent = Intent(this, registro::class.java)
            startActivity(intent)
        }

        binding.button1.setOnClickListener {
            val email = binding.mail.text?.trim().toString()
            val username = binding.name.text?.trim().toString()
            val password = binding.password.text?.trim().toString()
            signUp(email, username, password)
        }

    }

    private fun signUp(username: String, password: String, email: String) {
        val progressDialog = ProgressDialog(this)
        val email = binding.mail.text?.trim().toString()
        val username = binding.name.text?.trim().toString()
        val password = binding.password.text?.trim().toString()
        val passwordAgain = binding.passwordAgain.text?.trim().toString()

        progressDialog.show()
        val user = ParseUser()
        user.username = username
        user.setPassword(password)
        user.email = email
        user.signUpInBackground(SignUpCallback {
            progressDialog.dismiss()
            if (it == null || password == passwordAgain) {
                ParseUser.logOut()
                showAlert(
                    "Cuenta creada con éxito",
                    "Favor revisar su correo electronico para verificar su cuenta",
                    false
                )
            } else {
                ParseUser.logOut()
                showAlert("Error", "Cuenta no puede crearse" + " :" + it.message, true)
            }
        })
    }

    private fun showAlert(title: String, message: String, error: Boolean) {
        val builder = AlertDialog.Builder(this)
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton("OK") { dialog, which ->
                dialog.cancel()
                // don't forget to change the line below with the names of your Activities
                if (!error) {
                    val intent = Intent(this@login, registro::class.java)
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
                    startActivity(intent)
                }
            }
        val ok = builder.create()
        ok.show()
    }
}








