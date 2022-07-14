package com.example.bookapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.appcompat.widget.Toolbar
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity() {
    lateinit var drawerLayout:DrawerLayout
    lateinit var coordinateLayout:CoordinatorLayout
    lateinit var toolbar:Toolbar
    lateinit var frameLayout:FrameLayout
    lateinit var navigation:NavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawerLayout=findViewById(R.id.drawerLayout)
        coordinateLayout=findViewById(R.id.coordinateLayout)
        toolbar=findViewById(R.id.toolbar)
        frameLayout=findViewById(R.id.frameLayout)
        navigation=findViewById(R.id.navigation)
        setUpToolBar()

    }
    fun setUpToolBar()
    {
        //setsupportactionbar is a method to set up action bar
        setSupportActionBar(toolbar)
        supportActionBar?.title="Book Hub"
        supportActionBar?.setHomeButtonEnabled(true)
        //to display homebutton
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }


}