package com.eu.electrolab

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class Item1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        supportActionBar?.title =
            "item 1"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }
}