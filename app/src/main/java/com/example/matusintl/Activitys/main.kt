package com.example.matusintl.Activitys

import android.app.AlertDialog
import android.app.ProgressDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.matusintl.R
import com.example.matusintl.databinding.ActivityMainBinding
import com.parse.ParseUser


class main : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    private val userFragment = UserFragment()
    private val trackerFragment = trackerFragment()
    private val historyFragment = historyFragment()
    private val galleryFragment = galleryFragment()
    private val dashboardFragment = dashboardFragment()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        replaceFragment(dashboardFragment)

        val currentUser = ParseUser.getCurrentUser()
        if (currentUser != null) {
            // do stuff with the user
        } else {
            // show the signup or login screen
        }

        binding.bottomNav.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.inicio -> replaceFragment(dashboardFragment)
                R.id.Tracking -> replaceFragment(trackerFragment)
                R.id.history -> replaceFragment(historyFragment)
                R.id.gallery -> replaceFragment(galleryFragment)
                R.id.usuario -> replaceFragment(userFragment)
            }
            true
        }
        binding.out.setOnClickListener {
            signOut()
        }
    }


    private fun signOut() {
        val progressDialog = ProgressDialog(this)
        progressDialog.show()
        ParseUser.logOutInBackground { e ->
            progressDialog.dismiss()
            if (e == null)
                showAlert("Gracias por su preferencia", "¡Hasta pronto!")
            finish()
        }
    }

    private fun showAlert(title: String, message: String) {
        val builder = AlertDialog.Builder(this)
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton("OK") { dialog, which ->
                dialog.cancel()
                // don't forget to change the line below with the names of your Activities
            }
        val ok = builder.create()
        ok.show()
    }


    private fun replaceFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentContainer, fragment)
        transaction.commit()

    }


}
