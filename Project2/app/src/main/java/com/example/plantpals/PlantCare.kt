package com.example.plantpals

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class PlantCare : AppCompatActivity() {

    // Variable and View Declarations
    lateinit var plantName: TextView
    lateinit var plantImage: ImageView
    lateinit var plantGrowth: TextView
    lateinit var waterButton: Button
    lateinit var hugButton: Button
    lateinit var fertilizeButton: Button
    lateinit var pesticideButton: Button
    lateinit var heartImageView: ImageView
    lateinit var divider: ImageView
    var myPlant: Plant? = null

    // OnCreate
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_plant_care)

        // Getting plant from previous view
        val bundle = this.intent.extras
        if (bundle != null) {
            myPlant.let { myPlant = bundle.getSerializable("Plant") as Plant? }
        }

        // Find Views
        plantName = findViewById(R.id.plantName)
        plantImage = findViewById(R.id.plantImage)
        plantGrowth = findViewById(R.id.growthText)
        waterButton = findViewById(R.id.waterButton)
        hugButton = findViewById(R.id.hugButton)
        fertilizeButton = findViewById(R.id.fertilizerButton)
        pesticideButton = findViewById(R.id.pesticideButton)
        heartImageView = findViewById(R.id.heartImage)
        divider = findViewById(R.id.imageView3)

        // Define text and images based on the plant we received from Intent

        plantName.text = myPlant!!.name
        plantImage.setImageResource(myPlant!!.chooseImage())
        plantGrowth.text = "Growth: ${myPlant!!.waterPercentage.toString()}%"


        // Reference for how to make something disappear after 3 seconds.
        // https://stackoverflow.com/questions/3247554/how-to-show-a-view-for-3-seconds-and-then-hide-it
        // Water Button
        waterButton.setOnClickListener {

            // Adding a face for user feedback when watered (Disappears after 300ms)
            heartImageView.setImageResource(R.drawable.derp_smile)
            heartImageView.visibility = View.VISIBLE
            heartImageView.postDelayed(
                Runnable { heartImageView.visibility = View.INVISIBLE },
                300
            )
            pressWaterButton()
            Log.i("Alive?", myPlant!!.alive.toString())
            Log.i("Water?", myPlant!!.waterPercentage.toString())

            // If the plant is fully grown, move to completion screen
            if (myPlant!!.curStage == myPlant!!.totalStage - 1 && myPlant!!.numWaterInStage == 1){
                myPlant!!.water()
                val intentCare = Intent(this, EndPlant::class.java)
                intentCare.putExtra("Plant", myPlant)
                startActivity(intentCare)
            }
        }

        // Fertilize Button
        fertilizeButton.setOnClickListener {

            // Displaying temporary smile for user feedback
            heartImageView.setImageResource(R.drawable.fertilize_smile)
            heartImageView.visibility = View.VISIBLE
            heartImageView.postDelayed(Runnable { heartImageView.visibility = View.INVISIBLE }, 300)
            myPlant!!.fertilize()

            // If the plant is killed from fertilizer
            if (!myPlant!!.alive){
                val intentCare = Intent(this, EndPlant::class.java)
                intentCare.putExtra("Plant", myPlant)
                startActivity(intentCare)
            }
        }

        // Pesticide Button
        pesticideButton.setOnClickListener {

            // Temporary smile for user feedback
            heartImageView.setImageResource(R.drawable.pesticide_smile)
            heartImageView.visibility = View.VISIBLE
            heartImageView.postDelayed(Runnable { heartImageView.visibility = View.INVISIBLE }, 300)
            myPlant!!.pesticide()

            // If the plant is killed from pesticide
            if (!myPlant!!.alive){
                val intentCare = Intent(this, EndPlant::class.java)
                intentCare.putExtra("Plant", myPlant)
                startActivity(intentCare)
            }
        }

        // Hug Button
        hugButton.setOnClickListener {

            // Temporary smile for feedback
            heartImageView.setImageResource(R.drawable.hug_smile)
            heartImageView.visibility = View.VISIBLE
            heartImageView.postDelayed(Runnable { heartImageView.visibility = View.INVISIBLE }, 300)
            myPlant!!.hug()

            // If the plant is killed from hugging
            if (!myPlant!!.alive){
                val intentCare = Intent(this, EndPlant::class.java)
                intentCare.putExtra("Plant", myPlant)
                startActivity(intentCare)
            }
        }


        // Reference for getting screen width:
        // https://stackoverflow.com/questions/4743116/get-screen-width-and-height-in-android

        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        val height = displayMetrics.heightPixels
        val width = displayMetrics.widthPixels
        Log.i("WIDTH", "${width}")
        when (width){
            in 0..800 -> {
                divider.scaleX = 0.5F
                divider.scaleY = 0.5F

                plantImage.layoutParams.width = 150
                plantImage.layoutParams.height = 150
                heartImageView.layoutParams.width = 20
                heartImageView.layoutParams.width = 20

//                hugButton.layoutParams.width = 210
//                hugButton.layoutParams.height = 90
                hugButton.scaleX = 0.6F
                hugButton.scaleY = 0.6F


//                waterButton.layoutParams.width = 210
//                waterButton.layoutParams.height = 90
                waterButton.scaleX = 0.6F
                waterButton.scaleY = 0.6F

//                fertilizeButton.layoutParams.width = 210
//                fertilizeButton.layoutParams.height = 90
                fertilizeButton.scaleX = 0.6F
                fertilizeButton.scaleY = 0.6F

//                pesticideButton.layoutParams.width = 210
//                pesticideButton.layoutParams.height = 90
                pesticideButton.scaleX = 0.6F
                pesticideButton.scaleY = 0.6F

                plantImage.requestLayout()
            }
            in 800..1500 -> {
                plantImage.layoutParams.width = 700
                plantImage.layoutParams.height = 700

                plantImage.requestLayout()
            }
            in 1500..2500 ->{
                plantImage.layoutParams.width = 900
                plantImage.layoutParams.height = 900

                plantImage.requestLayout()
            }
        }

    }

    // Override back press to take it back to home screen
    override fun onBackPressed() {
        val homeIntent = Intent(this, MainActivity::class.java)
        homeIntent.putExtra("Plant", myPlant)
        startActivity(homeIntent)
        Log.i("BACK BUTTON TAPPED","OK")
        super.onBackPressed()

        finish()
    }

    // Calling water functions
    fun pressWaterButton(){
        if (myPlant!!.waterPercentage < 100) {
            myPlant!!.water()
            updateView()
        }
    }

    // Update View
    fun updateView(){
        plantImage.setImageResource(myPlant!!.chooseImage())
        plantGrowth.text = "Growth: ${myPlant!!.waterPercentage.toString()}%"
    }

}