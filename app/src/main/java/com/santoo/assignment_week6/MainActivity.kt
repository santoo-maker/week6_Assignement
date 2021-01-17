package com.santoo.assignment_week6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.santoo.assignment_week6.Fragments.AboutFragment
import com.santoo.assignment_week6.Fragments.AddStdFragment
import com.santoo.assignment_week6.Fragments.HomeFragment

class MainActivity : AppCompatActivity() {


    private lateinit var bottomNav : BottomNavigationView
    private lateinit var addStdFragment: AddStdFragment
    private lateinit var aboutFragment: AboutFragment
    private lateinit var homeFragment: HomeFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

            bottomNav= findViewById(R.id.bottomNav)

            bottomNav.setOnNavigationItemSelectedListener { item ->
                when(item.itemId){

                    R.id.home -> {
                        homeFragment = HomeFragment()
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.frameLayout, HomeFragment())
                            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                            .addToBackStack(null)
                            .commit()
                    }

                    R.id.addStd -> {
                        addStdFragment = AddStdFragment()
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.frameLayout, AddStdFragment())
                            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                            .addToBackStack(null)
                            .commit()
                    }

                    R.id.Aboutus -> {
                        aboutFragment = AboutFragment()
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.frameLayout, AboutFragment())
                            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                            .addToBackStack(null)
                            .commit()

                    }
                }

                true


            }
    }
}