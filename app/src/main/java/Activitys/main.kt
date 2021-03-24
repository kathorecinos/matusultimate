package Activitys

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.matusintl.R
import com.example.matusintl.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth


class main : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val userFragment = UserFragment()
    private val trackerFragment = trackerFragment()
    private val historyFragment = historyFragment()
    private val galleryFragment = galleryFragment()
    private val dashboardFragment = dashboardFragment()
    private lateinit var mAuth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        replaceFragment(dashboardFragment)
        mAuth = FirebaseAuth.getInstance()


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
    }

    fun onClick(view: View) {
        when (view.id) {
            R.id.out -> {
                mAuth.signOut()
                startActivity(Intent(this, Out::class.java))
                finish()
            }
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentContainer, fragment)
        transaction.commit()

    }
}
