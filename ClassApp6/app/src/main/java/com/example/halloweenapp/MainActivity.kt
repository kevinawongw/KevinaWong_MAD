package com.example.halloweenapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun sayBoo(view: android.view.View) {
        val booText = findViewById<TextView>(R.id.textMessage)
        booText.text = "Happy Halloweeeennn"
    }


}