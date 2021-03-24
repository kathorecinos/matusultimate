package Activitys

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.matusintl.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth


class login : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        supportActionBar?.hide()

        auth = FirebaseAuth.getInstance()

        binding.button2.setOnClickListener {
            val intent=Intent(this, registro::class.java)
            startActivity(intent)
        }

        binding.button1.setOnClickListener {
            if (binding.mail.text?.trim().toString().isNotEmpty() || binding.password.text?.trim().toString().isNotEmpty()){
                createUser(binding.mail.text?.trim().toString(), binding.password.text?.trim().toString() )
                Toast.makeText(this,"Datos enviados",Toast.LENGTH_LONG).show()

            }else{
                Toast.makeText(this,"Datos Requeridos",Toast.LENGTH_LONG).show()
            }
        }

    }

    fun createUser(email:String, password:String){
        auth.createUserWithEmailAndPassword(email,password)
            .addOnCompleteListener (this) { task ->

                if (task.isSuccessful) {
                    Log.e("Task Message", "Successful...")

                    var intent = Intent(this, main::class.java)
                    startActivity(intent)
                } else {
                    Log.e("Task Message", "Failed..." + task.exception)
                }

            }
    }


}