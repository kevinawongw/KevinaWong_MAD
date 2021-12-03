package com.example.plantpals

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import android.util.DisplayMetrics
import androidx.core.content.ContextCompat


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
lateinit var choosePlant: TextView

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
        choosePlant = findViewById(R.id.choosePlant)

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


        if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            seedLayout.layoutParams.height = height / 2
            seedImage.layoutParams.width = height / 4
        }
        else {
            seedLayout.layoutParams.width = width
            seedLayout.layoutParams.height = height / 7
            seedImage.layoutParams.width = width / 3
        }


        when (width){
            in 0..800 -> {
                if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                    seedText.textSize = 12.0F
                    choosePlant.setTextAppearance(this, R.style.TextAppearance_AppCompat_Large)
                    choosePlant.setTextColor(ContextCompat.getColor(this, R.color.plantPalGreen))
                }
                else {
                    seedText.textSize = 14.0F
                }
            }
            in 800..1500 -> {
                if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
                    seedText.textSize = 40.0F
                }
            }
            in 1500..3000 ->{
                if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) { seedLayout.layoutParams.height = height / 2
                            seedText.textSize = 70.0F
                    }
                    else {
                        seedText.textSize = 50.0F
                    }
                }
            }

        seedLayout.requestLayout()
        seedText.requestLayout()
        seedImage.requestLayout()
        choosePlant.requestLayout()

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

    // Save State on Rotation
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        seedImageId?.let {outState.putInt("plantImage", it)}
        seedName?.let {outState.putString("seedName", it)}

        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        seedImageId = savedInstanceState.getInt("plantImage")
        seedName?.let {savedInstanceState.getString("seedName")}

        updateView()
    }


}
