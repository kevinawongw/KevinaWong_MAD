package com.example.plantpals

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class EndPlant : AppCompatActivity() {

    // Variables and Views
    lateinit var plantName: TextView
    lateinit var plantImage: ImageView
    lateinit var plantAgainButton: Button
    lateinit var star1: ImageView
    lateinit var star2: ImageView
    lateinit var star3: ImageView
    lateinit var plantFeedback: TextView
    var myPlant: Plant? = null

    // OnCreate
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_end_plant)

        // Get Plant from Intent
        val bundle = this.intent.extras
        if (bundle != null) {
            myPlant.let { myPlant = bundle.getSerializable("Plant") as Plant? }
        }
        Log.i("Found Plant", "${myPlant!!.name}, at stage ${myPlant!!.curStage}")

        // Find Views
        plantName = findViewById(R.id.plantName)
        plantImage = findViewById(R.id.plantImage)
        plantAgainButton = findViewById<Button>(R.id.playAgainButton)
        star1 = findViewById(R.id.star1)
        star2 = findViewById(R.id.star2)
        star3 = findViewById(R.id.star3)
        plantFeedback = findViewById(R.id.plantFeedback)

        // Load text and image based on the plant from intent
        plantName.text = myPlant!!.name
        plantImage.setImageResource(myPlant!!.chooseImage())

        // Play again :) (clears plant as it is fully grown and takes user to home screen)
        plantAgainButton.setOnClickListener {
            val homeIntent = Intent(this, MainActivity::class.java)
            myPlant = null
            homeIntent.putExtra("Plant", myPlant)
            startActivity(homeIntent)
            Log.i("Starting Over",":)")
        }

        // Show stars and feedback
        myPlant!!.getStars()
        when (myPlant!!.stars){
            1 ->  {
                star1.setImageResource(R.drawable.star)
                plantFeedback.text = "${myPlant!!.name} is fully grown but felt unloved. It's a plant, but is it a pal?"

            }
            2 -> {
                star1.setImageResource(R.drawable.star)
                star2.setImageResource(R.drawable.star)
                plantFeedback.text = "${myPlant!!.name} has grown to be an average, comfortable plant bud."

            }
            3 -> {
                star1.setImageResource(R.drawable.star)
                star2.setImageResource(R.drawable.star)
                star3.setImageResource(R.drawable.star)
                plantFeedback.text = " WOW ${myPlant!!.name} is fully grown and is the happiest plant pal! Besties for life!"

            }
            else -> {
                star1.setImageResource(R.drawable.unfilled_star)
                star2.setImageResource(R.drawable.unfilled_star)
                star3.setImageResource(R.drawable.unfilled_star)
            }
        }

        // If your plant died
        if (!myPlant!!.alive){
            when(myPlant!!.deathBy){
                DeathBy.HUGS -> {
                    plantFeedback.text = "You hugged ${myPlant!!.name} so much that you squashed it to death! You killer :("
                }
                DeathBy.FERTILIZER -> {
                    plantFeedback.text = "Noo! You poisoned ${myPlant!!.name} with too much fertilizer! He was drugged to death :("
                }
                DeathBy.PESTICIDE -> {
                    plantFeedback.text = "${myPlant!!.name} was BUGGED by the pesticide! You gave it too much and it died. :("
                }
            }
        }
    }

    // Override back press - takes user to home screen
    override fun onBackPressed() {
        val homeIntent = Intent(this, MainActivity::class.java)
        myPlant = null
        homeIntent.putExtra("Plant", myPlant)
        startActivity(homeIntent)
        Log.i("BACK BUTTON TAPPED","OK")
        super.onBackPressed()
        finish()
    }
}