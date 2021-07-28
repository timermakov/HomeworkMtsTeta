package com.timermakov.homeworkmtsteta.activities

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.timermakov.homeworkmtsteta.R
import com.timermakov.homeworkmtsteta.fragments.MainFragment
import com.timermakov.homeworkmtsteta.fragments.ProfileFragment
import com.timermakov.homeworkmtsteta.functions.replaceFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        initViews()
    }

    private fun initViews() {
        findViewById<View>(R.id.bottomNavigationMain).visibility = View.VISIBLE
        findViewById<View>(R.id.bottomNavigationProfile).visibility = View.INVISIBLE
        replaceFragment(this, MainFragment(), false)
        findViewById<BottomNavigationView>(R.id.mainActivityBottomNavigationView).setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.main -> {
                    replaceFragment(this, MainFragment(), false)
                    findViewById<View>(R.id.bottomNavigationMain).visibility = View.VISIBLE
                    findViewById<View>(R.id.bottomNavigationProfile).visibility = View.INVISIBLE
                    true
                }
                R.id.profile -> {
                    replaceFragment(this, ProfileFragment(), false)
                    findViewById<View>(R.id.bottomNavigationMain).visibility = View.INVISIBLE
                    findViewById<View>(R.id.bottomNavigationProfile).visibility = View.VISIBLE
                    true
                }
                else -> false
            }
        }
    }

}