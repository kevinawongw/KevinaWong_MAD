package com.example.lab6

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

    fun toLower(myString: String): String{
        var output: String = ""
        for (i in myString){
            output += i.lowercaseChar()
        }
        return output
    }

    fun determineHoroscope(view: android.view.View){
        val horoscopeEntry = findViewById<EditText>(R.id.horoscope).text
        val horoscopeLower = toLower(horoscopeEntry.toString())
        val image = findViewById<ImageView>(R.id.horoscopeImage)

        if (horoscopeLower == "aquarius") {
            image.setImageResource(R.drawable.aquarius)
        }

    }
}
