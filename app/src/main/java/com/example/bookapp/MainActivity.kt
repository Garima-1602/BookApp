package com.example.bookapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.FrameLayout
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.GravityCompat
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

//make a toggle  and place it in action bar which is action bar toggle
        val actionBarDrawerToggle= ActionBarDrawerToggle(
            this@MainActivity,
            drawerLayout,
            R.string.open_drawer,
            R.string.close_drawer
        )
        //make homebutton functional
        //to make hamsburger clickable
        //to add clicklistener to toggle
        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        //to change hamsburger icon to back icon and vice versa
        //sync the toggle
        actionBarDrawerToggle.syncState()
    }
    fun setUpToolBar()
    {
        //setsupportactionbar is a method to set up action bar

        setSupportActionBar(toolbar)
        supportActionBar?.title="Book Hub"
        //enble homebutton
        supportActionBar?.setHomeButtonEnabled(true)
        //to display homebutton
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
//to add action  click listener to action bar
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id=item.itemId //extracting id of item and store in id
        if(id==android.R.id.home)
        {
            //use open drawer to start from left
            drawerLayout.openDrawer(GravityCompat.START)
        }
        return super.onOptionsItemSelected(item)

    }

}
//steps to add hamsburger icon
//enable homebutton
//make toggle and place it in action bar
//add click listener on method using addDrawerListerner methos
//sync the toggle with navigation drawer
//use onOptionsItemSelected to add click listener to action bar
//use drawermethod to make drawer open from left side of app