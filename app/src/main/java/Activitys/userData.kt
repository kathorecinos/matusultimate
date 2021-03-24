package Activitys

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
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
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
            val Telefono = binding.textInputNumber2.text.toString()
            saveFireStore(Nombre, Importadora, Correo, Telefono)


            val url="https://script.google.com/macros/s/AKfycbz2wKUv87zi3xWIHY9UZQa3pU9DWKcRLA9X1SP-0MX_jsC-wE90/exec"
            val stringRequest=object :StringRequest(com.android.volley.Request.Method.POST,url,
                Response.Listener {
                                  Toast.makeText(this@userData,it.toString(),Toast.LENGTH_SHORT).show()
                },
                Response.ErrorListener {
                    Toast.makeText(this@userData,it.toString(),Toast.LENGTH_SHORT).show()
                }){
                override fun getParams(): MutableMap<String, String> {
                    val params=HashMap<String,String>()
                    params["Nombre"]=binding.textInputName2.text.toString()
                    params["Importadora"]=binding.textInputImportadora2.text.toString()
                    params["Correo"]=binding.textInputMail2.text.toString()
                    params["Telefono"]=binding.textInputNumber2.text.toString()
                    return params
                }
            }
            val queue=Volley.newRequestQueue(this@userData)
            queue.add(stringRequest)

        }

        binding.buttonChangeProfilePic.setOnClickListener {
            startFileChooser()
        }
        binding.buttonChange.setOnClickListener {
            uploadFile()
        }

    }


    private fun uploadFile() {
        if (filepath!=null){
            var pd=ProgressDialog(this)
            pd.setTitle("Uploading")
            pd.show()

            var imageRef = FirebaseStorage.getInstance().reference.child("images/pic.jpg")
            imageRef.putFile(filepath)
                .addOnSuccessListener {p0 ->
                    pd.dismiss()
                    Toast.makeText(applicationContext,"File Uploaded", Toast.LENGTH_LONG).show()
                }
                .addOnFailureListener {p0 ->
                    pd.dismiss()
                    Toast.makeText(applicationContext, p0.message, Toast.LENGTH_LONG).show()

                }
                .addOnProgressListener { p0 ->
                    var progress = (100.0 * p0.bytesTransferred) / p0.totalByteCount
                    pd.setMessage("Uploaded ${progress.toInt()}%")

                }
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
            binding.circuloUser.setImageBitmap(bitmap)
        }
    }


    private fun saveFireStore(
        Nombre: String,
        Importadora: String,
        Correo: String,
        Telefono: String
    ) {
        val db = FirebaseFirestore.getInstance()
        val user: MutableMap<String, Any> = HashMap()
        user["Nombre"] = Nombre
        user["Importadora"] = Importadora
        user["Correo"] = Correo
        user["Telefono"] = Telefono

        db.collection("users")
            .add(user)
            .addOnSuccessListener {
                Toast.makeText(this@userData, "record added succesfully", Toast.LENGTH_LONG).show()
                var intent = Intent(this, dataSendActivity::class.java)
                startActivity(intent)
            }
            .addOnFailureListener {
                Toast.makeText(this@userData,"record failed", Toast.LENGTH_LONG).show()
            }

    }


}