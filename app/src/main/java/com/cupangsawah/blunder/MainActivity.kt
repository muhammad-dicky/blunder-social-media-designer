package com.cupangsawah.blunder

import android.content.Intent
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.cupangsawah.blunder.Fragments.HomeFragment
import com.cupangsawah.blunder.Fragments.NotificationsFragment
import com.cupangsawah.blunder.Fragments.ProfileFragment
import com.cupangsawah.blunder.Fragments.SearchFragment

class MainActivity : AppCompatActivity() {

//    private lateinit var textView: TextView
//    internal var selectedFragment: Fragment? = null

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.nav_home -> {
//                textView.setText ("Home")
//                return@OnNavigationItemSelectedListener true
//                selectedFragment = HomeFragment()
                moveToFragment(HomeFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_search -> {
//                textView.setText ("Search")
//                return@OnNavigationItemSelectedListener true
//                selectedFragment = SearchFragment()
                moveToFragment(SearchFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_add_post -> {
                item.isChecked = false
                startActivity(Intent(this@MainActivity, AddPostActivity::class.java))
//                textView.setText ("Add Post")
                return@OnNavigationItemSelectedListener true

            }
            R.id.nav_notifications -> {
//                textView.setText ("Notifications")
//                return@OnNavigationItemSelectedListener true
//                selectedFragment = NotificationsFragment()
                moveToFragment(NotificationsFragment())
                return@OnNavigationItemSelectedListener true
            }


            R.id.nav_profile -> {
//                textView.setText ("Profile")
//                return@OnNavigationItemSelectedListener true
//                selectedFragment = ProfileFragment()
                moveToFragment(ProfileFragment())
                return@OnNavigationItemSelectedListener true
            }
        }

        //jika user klik fragment lain maka akan mengarahkan sesuai selectedFragment (default HomeFragment)
//        if (selectedFragment != null){
//            supportFragmentManager.beginTransaction().replace(
//                    R.id.fragment_container,
//                    selectedFragment!!
//            ).commit()
//        }
        false
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navView: BottomNavigationView = findViewById(R.id.nav_view)
//        textView = findViewById(R.id.message)
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

//        supportFragmentManager.beginTransaction().replace(
//                R.id.fragment_container,
//                HomeFragment()
//        ).commit()
        moveToFragment(HomeFragment())
    }

    //untuk mengububah warna icon sesuai fragment yang dibuka
    private fun moveToFragment (fragment: Fragment){
        val fragmentTrans = supportFragmentManager.beginTransaction()
        fragmentTrans.replace(R.id.fragment_container, fragment)
        fragmentTrans.commit()
    }
}