package com.eu.electrolab

import android.content.Intent
import android.content.res.Resources
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import java.util.*


class MainActivity : AppCompatActivity() {
    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager2
    private lateinit var toggle: ActionBarDrawerToggle


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)

        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        navView.setNavigationItemSelectedListener {

            when (it.itemId) {
                R.id.nav_home -> Toast.makeText(applicationContext, "Clicked ", Toast.LENGTH_SHORT)
                    .show()
                R.id.translante -> Toast.makeText(
                    applicationContext,
                    "Clicked ",
                    Toast.LENGTH_SHORT
                ).show()
                R.id.parametre -> {val intent = Intent(applicationContext, ParametreActivity::class.java)
                    applicationContext.startActivity(intent) }
            }
            true
        }
        tabLayout = findViewById(R.id.tabLayout)
        viewPager = findViewById(R.id.viewPager)
        viewPager.adapter = PagerAdapter(this)
        TabLayoutMediator(tabLayout, viewPager) { tab, index ->
            tab.text = when (index) {
                0 -> {
                    "calculator"
                }
                1 -> {
                    "schematic"
                }
                2 -> {
                    "learning"
                }
                else -> {
                    throw Resources.NotFoundException("position not found")
                }
            }
        }.attach()
        val countries= arrayOf("francais","english","chinois")

     /* val adapter=ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,countries)
        spinner.adapter=adapter
        spinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
               /* when(p2){
                    0->{Toast.makeText(this@MainActivity,"english",Toast.LENGTH_SHORT).show()}
                    1->{Toast.makeText(this@MainActivity,"francais",Toast.LENGTH_SHORT).show()}
                    2->{Toast.makeText(this@MainActivity,"chinois",Toast.LENGTH_SHORT).show()}
                    3->{Toast.makeText(this@MainActivity,"allemand",Toast.LENGTH_SHORT).show()}*/


                /*val selectedItem = countries[p2]
                setLanguage(selectedItem.locale)*/


            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }*/
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
    return false
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.option_menu, menu)
        return true
    }

    /*override fun onResume() {
        super.onResume()
        setLanguage("fr")
    }
    private fun setLanguage(selectedLocale: String){


        val newLocale= Locale(selectedLocale)
        resources.configuration.setLocale(Locale(selectedLocale))
        resources.updateConfiguration(resources.configuration,resources.displayMetrics)
        val defaultLocale = Locale.getDefault()
        if (defaultLocale.language!=selectedLocale) {
            Locale.setDefault(newLocale)
            recreate()
    }*/
}