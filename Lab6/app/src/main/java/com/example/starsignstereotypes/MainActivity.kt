package com.example.starsignstereotypes

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
        val horoText = findViewById<TextView>(R.id.horoscopeName)
        val horoscopeLower = toLower(horoscopeEntry.toString())
        val image = findViewById<ImageView>(R.id.horoscopeImage)
        val horoscopeMess = findViewById<TextView>(R.id.horoscopeMessage)

        if (horoscopeLower == "aries") {
            image.setImageResource(R.drawable.aries)
            horoText.text = "Aries"
            horoscopeMess.text = "Don't RAM into the situation! Aries are impatient and impulsive!"

        }
        else if (horoscopeLower == "taurus") {
            image.setImageResource(R.drawable.taurus)
            horoText.text = "Taurus"
            horoscopeMess.text = "Don't be so BULL-Headed! Taurus are really stubborn!"
        }
        else if (horoscopeLower == "gemini") {
            image.setImageResource(R.drawable.gemini)
            horoText.text = "Gemini"
            horoscopeMess.text = "Wow! There's two of you!? Gemini constanty change their views and are open to many truths! "
        }
        else if (horoscopeLower == "cancer") {
            image.setImageResource(R.drawable.cancer)
            horoText.text = "Cancer"
            horoscopeMess.text = "Are you CRABBY? Cancers are moody and hypersensitive!"
        }
        else if (horoscopeLower == "leo") {
            image.setImageResource(R.drawable.leo)
            horoText.text = "Leo"
            horoscopeMess.text = "No Way, are you LION? Leos are proud, egocentric, and tend to be show-offs!"
        }
        else if (horoscopeLower == "virgo") {
            image.setImageResource(R.drawable.virgo)
            horoText.text = "Virgo"
            horoscopeMess.text = "Virgos are compulsively clean and orderly! (+ they are the BEST star sign!)"
        }
        else if (horoscopeLower == "libra") {
            image.setImageResource(R.drawable.libra)
            horoText.text = "Libra"
            horoscopeMess.text = "Libras can'r make up their minds!"
        }
        else if (horoscopeLower == "scorpio") {
            image.setImageResource(R.drawable.scorpio)
            horoText.text = "Scorpio"
            horoscopeMess.text = "That STINGS! Scorpios are very intense!"
        }
        else if (horoscopeLower == "sagittarius") {
            image.setImageResource(R.drawable.sagittarius)
            horoText.text = "Sagittarius"
            horoscopeMess.text = "Sagittarius are ready to hop off when things get too complicated!"
        }
        else if (horoscopeLower == "capricorn") {
            image.setImageResource(R.drawable.capricorn)
            horoText.text = "Capricorn"
            horoscopeMess.text = "You must be the GOAT because you will step on anyone to get to the top!"
        }
        else if (horoscopeLower == "pisces") {
            image.setImageResource(R.drawable.pisces)
            horoText.text = "Pisces"
            horoscopeMess.text = "You seem FISHY, why are you so spaced out? Pisces tend to be escapists!"
        }
        else if (horoscopeLower == "aquarius") {
            image.setImageResource(R.drawable.aquarius)
            horoText.text = "Aquarius"
            horoscopeMess.text = "Aquarius are emotionless and detached! So cold!!"
        }
        else{
            image.setImageResource(R.drawable.tarot)
            horoText.text = "That's not a horoscope!"
            horoscopeMess.text = ":("

        }

    }
}


