package com.example.spotifyclone

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.spotifyclone.fragments.HomeFragment
import com.example.spotifyclone.fragments.MembersFragment
import com.example.spotifyclone.fragments.SettingsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        bottomNav.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_home -> {
                    loadFragment(HomeFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.nav_members -> {
                    loadFragment(MembersFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.nav_settings -> {
                    loadFragment(SettingsFragment())
                    return@setOnNavigationItemSelectedListener true
                }
            }
            false
        }

        loadFragment(HomeFragment())
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).commit()
    }
}
