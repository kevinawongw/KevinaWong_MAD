package com.example.plantpals

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    // Variables and Views
    lateinit var helpFAB: FloatingActionButton
    lateinit var overlay: View
    lateinit var newPlant: Button
    lateinit var resumePlant: Button
    lateinit var titleText: TextView
    lateinit var helpInstructions: TextView
    private var fabImage: Int = 0
    lateinit var newPlantButton: Button
    lateinit var houseImageView: ImageView
    var myPlant: Plant? = null

    // OnCreate
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find Views
        helpFAB = findViewById(R.id.helpFAB)
        overlay = findViewById(R.id.helpOverlay)
        newPlant = findViewById(R.id.newPlantButton)
        resumePlant = findViewById(R.id.resumePlantButton)
        titleText = findViewById(R.id.plantpalsTitle)
        helpInstructions = findViewById(R.id.instructionText)
        newPlantButton = findViewById(R.id.newPlantButton)
        houseImageView = findViewById(R.id.imageView)


        // Moving to next activity if the user wants to select a new plant
        newPlantButton.setOnClickListener{
            val intent = Intent(this, selectNewPlant::class.java)
            startActivity(intent)
        }

        // Receiving plant from another view (used for the "Resume Plant" option)
        val bundle = this.intent.extras
        if (bundle != null) {
            myPlant.let { myPlant = bundle.getSerializable("Plant") as Plant? }
        }

        // If the user wants to resume plant, take it to the plant care activity
        resumePlant.setOnClickListener{
            val intent = Intent(this, PlantCare::class.java)
            intent.putExtra("Plant", myPlant)
            startActivity(intent)
        }

        // If there is no plant to be resumed, disable the button and change the color for user knowledge
        if (myPlant == null){
            Log.i("Clickable?", "There is no Plant!")
            resumePlant.isClickable = false
            resumePlant.setBackgroundColor(Color.GRAY)
        }
        else{
            resumePlant.isClickable = true
            Log.i("Resume Plant:", com.example.plantpals.myPlant!!.name)
            resumePlant.setBackgroundColor(getResources().getColor(R.color.plantPalGreen))
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
                houseImageView.layoutParams.width = 200

                houseImageView.requestLayout()
            }
            in 800..1500 -> {
                houseImageView.layoutParams.width = 800

                houseImageView.requestLayout()
            }
            in 1500..2500 ->{
                houseImageView.layoutParams.width = 1000
                houseImageView.requestLayout()
            }
        }

    }

    // Override back press
    override fun onBackPressed() {
        val homeIntent = Intent(this, MainActivity::class.java)
        startActivity(homeIntent)
        Log.i("BACK BUTTON TAPPED","OK")
        super.onBackPressed()

        finish()
    }

    // Help Overlay
    fun showOverlay(view: android.view.View){
        if (overlay.visibility == View.VISIBLE) {
            fabImage = android.R.drawable.ic_menu_help
        }
        else{
            fabImage = android.R.drawable.ic_menu_close_clear_cancel
        }
        updateHelpView()
    }

    // Toggle on and off help FAB
    fun updateHelpView(){
        if (overlay.visibility == View.VISIBLE) {

            // Make View Invisible (Default)
            overlay.visibility = View.INVISIBLE
            newPlant.visibility = View.VISIBLE
            resumePlant.visibility = View.VISIBLE
            helpInstructions.visibility = View.INVISIBLE

            helpFAB.setImageResource(fabImage)
        }
        else{

            // Make Overview Visible
            overlay.visibility = View.VISIBLE
            newPlant.visibility = View.INVISIBLE
            resumePlant.visibility = View.INVISIBLE
            helpInstructions.visibility = View.VISIBLE
            helpFAB.setImageResource(fabImage);
        }
    }

}