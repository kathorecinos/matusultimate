package com.example.matusintl.Activitys

import android.app.AlertDialog
import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.biometric.BiometricPrompt
import androidx.core.content.ContextCompat
import com.example.matusintl.databinding.ActivityRegistroBinding
import com.parse.ParseException
import com.parse.ParseUser
import java.util.concurrent.Executor


class registro : AppCompatActivity() {

    private lateinit var binding: ActivityRegistroBinding
    private lateinit var executor: Executor
    private lateinit var biometricPrompt: BiometricPrompt
    private lateinit var promptInfo: BiometricPrompt.PromptInfo


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistroBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        supportActionBar?.hide()

        executor = ContextCompat.getMainExecutor(this)



        biometricPrompt = BiometricPrompt(
            this@registro,
            executor,
            object : BiometricPrompt.AuthenticationCallback() {
                override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
                    super.onAuthenticationError(errorCode, errString)
                    Toast.makeText(this@registro, "Vuelva a ingresar su huella", Toast.LENGTH_SHORT)
                        .show()
                }

                override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                    super.onAuthenticationSucceeded(result)
                    Toast.makeText(this@registro, "Acceso Aceptado", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this@registro, main::class.java))

                }

                override fun onAuthenticationFailed() {
                    super.onAuthenticationFailed()
                    Toast.makeText(this@registro, "Vuelva a ingresar su huella", Toast.LENGTH_SHORT)
                        .show()
                }

            })
        promptInfo= BiometricPrompt.PromptInfo.Builder()
            .setTitle("Ingrese su huella")
            .setSubtitle("Para ingresar a su MatusApp solo ponga su dedo en la huella para reconocimiento dactilar")
            .setNegativeButtonText("Usar contraseña")
            .build()

        binding.button2.setOnClickListener {
            biometricPrompt.authenticate(promptInfo)
        }



        binding.button1.setOnClickListener {
            if (binding.mail.text?.trim().toString().isNotEmpty() || binding.password.text?.trim()
                    .toString().isNotEmpty()
            ) {
                loginUser(
                    binding.mail.text?.trim().toString(),
                    binding.password.text?.trim().toString()
                )
            } else {
                Toast.makeText(this, "Datos requeridos", Toast.LENGTH_LONG).show()
            }
        }

    }


    fun loginUser(mail: String, password: String) {

        val progressDialog = ProgressDialog(this)
        val mail = binding.mail.text?.trim().toString()
        val password = binding.password.text?.trim().toString()

        progressDialog.show()
        ParseUser.logInInBackground(mail, password) { parseUser: ParseUser?, e: ParseException? ->
            progressDialog.dismiss()
            if (parseUser != null) {
                showAlert(
                    "Ingreso con éxito",
                    "Bienvenido, ${ParseUser.getCurrentUser().username}!",
                    false
                )
                startActivity(Intent(this@registro, main::class.java))
            } else {
                ParseUser.logOut()
                showAlert("Ingreso fallido", e?.message + " Vuelva a intentarlo", true)
            }
        }


    }

    private fun showAlert(title: String, message: String, error: Boolean) {
        val builder = AlertDialog.Builder(this)
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton("OK") { dialog, which ->
                dialog.cancel()
                // don't forget to change the line below with the names of your Activities
                if (!error) {
                    val intent = Intent(this@registro, login::class.java)
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
                    startActivity(intent)
                }
            }
        val ok = builder.create()
        ok.show()
    }
}