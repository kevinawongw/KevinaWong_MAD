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
        val horoscopeEntry = findViewById<EditText>(R.id.horoscopeInput).text
        val horoText = findViewById<TextView>(R.id.horoscopeName)
        val horoscopeMessage = findViewById<TextView>(R.id.horoscopeText)
        val horoscopeLower = toLower(horoscopeEntry.toString())
        val image = findViewById<ImageView>(R.id.horoscopeImage)

        if (horoscopeLower == "aries") {
            image.setImageResource(R.drawable.aries)
            horoText.text = "Aries"
            horoscopeMessage.text = "Aries are impatient! They jump head first into whatever they're drawn to!"
        }
        else if (horoscopeLower == "taurus") {
            image.setImageResource(R.drawable.taurus)
            horoText.text = "Taurus"
            horoscopeMessage.text = "Don't be so BULL-headed! Taurus are stubborn!"
        }
        else if (horoscopeLower == "gemini") {
            image.setImageResource(R.drawable.gemini)
            horoText.text = "Gemini"
            horoscopeMessage.text = "Wait, there's two of you!? Gemini are constantly changing their minds and views"
        }
        else if (horoscopeLower == "cancer") {
            image.setImageResource(R.drawable.cancer)
            horoText.text = "Cancer"
            horoscopeMessage.text = "Are you a little CRABBY? Cancers are moody and hypersensitive!"

        }
        else if (horoscopeLower == "leo") {
            image.setImageResource(R.drawable.leo)
            horoText.text = "Leo"
            horoscopeMessage.text = "You're not LION are you? Leos are proud, self-absorbed, and tend to be show-offs"
        }
        else if (horoscopeLower == "virgo") {
            image.setImageResource(R.drawable.virgo)
            horoText.text = "Virgo"
            horoscopeMessage.text = "Virgos love perfection and cleanliness (+ they are the best)"
        }
        else if (horoscopeLower == "libra") {
            image.setImageResource(R.drawable.libra)
            horoText.text = "Libra"
            horoscopeMessage.text = "Libras cannot make up their mind!"
        }
        else if (horoscopeLower == "scorpio") {
            image.setImageResource(R.drawable.scorpio)
            horoText.text = "Scorpio"
            horoscopeMessage.text = "That's a stinger! Scorpios are too intense!"
        }
        else if (horoscopeLower == "sagittarius") {
            image.setImageResource(R.drawable.sagittarius)
            horoText.text = "Sagittarius"
            horoscopeMessage.text = "Sagittarius are always ready to dip out if things are too heavy!"
        }
        else if (horoscopeLower == "capricorn") {
            image.setImageResource(R.drawable.capricorn)
            horoText.text = "Capricorn"
            horoscopeMessage.text = "You must be the GOAT! Capricorns will step on anyone to get to the top"
        }
        else if (horoscopeLower == "pisces") {
            image.setImageResource(R.drawable.pisces)
            horoText.text = "Pisces"
            horoscopeMessage.text = "You must have a brain the size of a FISH! Pisces are often spaced out!"

        }
        else if (horoscopeLower == "aquarius") {
            image.setImageResource(R.drawable.aquarius)
            horoText.text = "Aquarius"
            horoscopeMessage.text = "Aquarius are emotionless and detached! So cold!"
        }
        else{
            image.setImageResource(R.drawable.tarot)
            horoText.text = "That's not a star sign!"
            horoscopeMessage.text = ":("

        }

    }
}

