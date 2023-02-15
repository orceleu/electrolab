package com.eu.electrolab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import com.google.android.material.navigation.NavigationView
import java.util.*

class ParametreActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parametre)
        val spinner: Spinner = findViewById(R.id.spinner_translante)

        val countries= arrayOf("francais","english","chinois","allemand")

         val adapter= ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,countries)
           spinner.adapter=adapter
           spinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
               override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                   when(p2){
                       0->{
                           Toast.makeText(this@ParametreActivity,"english",Toast.LENGTH_SHORT).show()}
                       1->{Toast.makeText(this@ParametreActivity,"francais",Toast.LENGTH_SHORT).show()}
                       2->{Toast.makeText(this@ParametreActivity,"chinois",Toast.LENGTH_SHORT).show()}
                       3->{Toast.makeText(this@ParametreActivity,"allemand",Toast.LENGTH_SHORT).show()}


                  /* val selectedItem = countries[p2]
                   setLanguage(selectedItem.locale)*/


               }


           }

               override fun onNothingSelected(p0: AdapterView<*>?) {
                   TODO("Not yet implemented")
               }



               /*
               override fun onResume() {
      super.onResume()
      setLanguage("fr")*/
  }
   fun setLanguage(selectedLocale: String){


      val newLocale= Locale(selectedLocale)
      resources.configuration.setLocale(Locale(selectedLocale))
      resources.updateConfiguration(resources.configuration,resources.displayMetrics)
      val defaultLocale = Locale.getDefault()
      if (defaultLocale.language!=selectedLocale) {
          Locale.setDefault(newLocale)
          recreate()
  }
}}}
