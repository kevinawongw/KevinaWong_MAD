package com.example.plantpals

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import android.util.DisplayMetrics




// Variables and Views
private var seedImageId = 0
private var seedName = ""
private var optionalName = ""
lateinit var seedImage: ImageView
lateinit var seedText: TextView
lateinit var linearLayout: LinearLayout
lateinit var selectButton: Button
lateinit var customName: EditText
lateinit var seedLayout: LinearLayout
var myPlant: Plant? = null

class selectNewPlant : AppCompatActivity() {

    // OnCreate
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_new_plant)

        // Define Views
        seedImage = findViewById(R.id.seedSelecttionImage)
        seedText = findViewById(R.id.seedSelectionText)
        linearLayout = findViewById(R.id.plantLinear)
        selectButton = findViewById(R.id.selectButton)
        customName = findViewById(R.id.optionalName)
        seedLayout = findViewById(R.id.seedLinear)

        // Select Plant Listener (Will create plant and pass the plant onto next activity)
        selectButton.setOnClickListener{
            createPlant()
            val intentCare = Intent(this, PlantCare::class.java)
            intentCare.putExtra("Plant", myPlant)
            startActivity(intentCare)
        }

        // Dynamically change size based on screen width

        // Reference for getting screen width:
        // https://stackoverflow.com/questions/4743116/get-screen-width-and-height-in-android

        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        val height = displayMetrics.heightPixels
        val width = displayMetrics.widthPixels
        Log.i("WIDTH", "${width}")
        when (width){
            in 0..800 -> {
                seedImage.layoutParams.width = 200
                seedLayout.layoutParams.height = 90
                seedText.textSize = 14.0F
                seedImage.requestLayout()
            }
            in 800..1500 -> {
                seedImage.layoutParams.width = 700
                seedLayout.layoutParams.height = 350
                seedText.textSize = 40.0F

                seedImage.requestLayout()
            }
            in 1500..2500 ->{
                seedImage.layoutParams.width = 900
                seedLayout.layoutParams.height = 400
                seedText.textSize = 50.0F
                seedImage.requestLayout()
            }
        }

    }

    // Override Back press to main title screen
    override fun onBackPressed() {
        val homeIntent = Intent(this, MainActivity::class.java)
        homeIntent.putExtra("Plant", myPlant)
        startActivity(homeIntent)
        Log.i("BACK BUTTON TAPPED","OK")
        super.onBackPressed()
        finish()
    }

    // Display Tulip
    fun displayTulipOption(view: android.view.View) {
        seedImageId = R.drawable.tulip
        seedName = "Tulip"
        updateView()
    }

    // Display Tree
    fun displayTreeOption(view: android.view.View) {
        seedImageId = R.drawable.appletree
        seedName = "Apple Tree"
        updateView()
    }

    // Display Garlic
    fun displayGarlicOption(view: android.view.View) {
        seedImageId = R.drawable.garlic
        seedName = "Garlic"
        updateView()
    }

    fun updateView(){
        linearLayout.visibility = View.VISIBLE
        seedImage.setImageResource(seedImageId)
        seedText.text = seedName
    }

    // Function to call plant constuctor when a plant is selected
    fun createPlant(){
        optionalName = customName.text.toString()
        Log.i("Pressed", seedName)
        Log.i("w Name", "\"${optionalName}\"")

        // Switch case to create the right type to plant
        when (seedName){
            "Tulip" -> {
                if (optionalName == ""){
                    myPlant = Plant(PlantType.TULIP, seedName)
                }
                else{
                    myPlant = Plant(PlantType.TULIP, optionalName)
                }
            }
            "Apple Tree" -> {
                if (optionalName == ""){
                    myPlant = Plant(PlantType.TREE, seedName)
                }
                else{
                    myPlant = Plant(PlantType.TREE, optionalName)
                }
            }
            "Garlic" -> {
                if (optionalName == ""){
                    myPlant = Plant(PlantType.GARLIC, seedName)
                }
                else{
                    myPlant = Plant(PlantType.GARLIC, optionalName)
                }
            }
            else ->{
                myPlant = null
            }
        }
        myPlant?.let { Log.i("PlantCreated!", it.name) }
    }

}
