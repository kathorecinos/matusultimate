package Activitys

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.biometric.BiometricPrompt
import androidx.core.content.ContextCompat
import com.example.matusintl.databinding.ActivityRegistroBinding
import com.google.firebase.auth.FirebaseAuth
import java.util.concurrent.Executor

class registro : AppCompatActivity() {

    private lateinit var binding: ActivityRegistroBinding
    private lateinit var executor: Executor
    private lateinit var biometricPrompt: BiometricPrompt
    private lateinit var promptInfo: BiometricPrompt.PromptInfo

    private lateinit var auth: FirebaseAuth

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


        auth = FirebaseAuth.getInstance()

        binding.button1.setOnClickListener {
           if(binding.mail.text?.trim().toString().isNotEmpty()||binding.password.text?.trim().toString().isNotEmpty()) {
               signInUser(
                   binding.mail.text?.trim().toString(),
                   binding.password.text?.trim().toString()
               )
           }else{
               Toast.makeText(this, "Input required", Toast.LENGTH_LONG).show()
           }
        }
    }
    

    fun signInUser(mail:String,password:String){

        auth.signInWithEmailAndPassword(mail,password)
            .addOnCompleteListener (this) {task ->

                if (task.isSuccessful){
                    val intent = Intent(this, main::class.java)
                    startActivity(intent)
                }else{
                    Toast.makeText(this, "Error!!"+task.exception, Toast.LENGTH_LONG).show()
                }
            }



    }
}