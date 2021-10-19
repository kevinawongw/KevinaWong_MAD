package com.example.halloweenapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun sayBoo(view: android.view.View) {
        val booText = findViewById<TextView>(R.id.textMessage)
        val nameText = findViewById<EditText>(R.id.editTextName)
        val imageGhost = findViewById<ImageView>(R.id.imageView)

        booText.text = "Happy Halloweeeennn "  + nameText.text + "!"
        imageGhost.setImageResource(R.drawable.ghost)


    }


}