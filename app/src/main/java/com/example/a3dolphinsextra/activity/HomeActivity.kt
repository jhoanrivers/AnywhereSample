package com.example.a3dolphinsextra.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.a3dolphinsextra.R
import com.example.a3dolphinsextra.fragment.*
import com.example.a3dolphinsextra.fragment.task_management.TaskFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {

    lateinit var bottomNav: BottomNavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        var token = intent.getStringExtra("token")


        val homeFragment = HomeFragment()
        val priorityFragment = PriorityFragment()
        val teamFragment = TeamFragment()
        val taskFragment = TaskFragment()
        val profileFragment = ProfileFragment()
        bottomNav = findViewById(R.id.btnNavView)

        setCurrentFragment(homeFragment)

        bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.ticket -> setCurrentFragment(homeFragment)
                R.id.priority -> setCurrentFragment(priorityFragment)
                R.id.team -> teamFragment?.let { it1 -> setCurrentFragment(it1) }
                R.id.task -> taskFragment?.let { it1 -> setCurrentFragment(it1) }
                R.id.profile -> setCurrentFragment(profileFragment)
            }
            true
        }




    }




    private fun setCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, fragment)
            commit()
        }

    }

}