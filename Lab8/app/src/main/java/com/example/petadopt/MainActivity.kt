package com.example.petadopt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    // Initialize Variables

    lateinit var dogButton: ImageButton
    lateinit var catButton: ImageButton
    lateinit var adoptButton: Button
    lateinit var layoutRoot: ConstraintLayout
    var backGroundIdDog: Int? = (R.drawable.rounded_corners)
    var backGroungIdCat: Int? = (R.drawable.rounded_corners)
    var petSelection: PetType? = null
    var myPet: Pet? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Define Variables and Find Views
        dogButton = findViewById(R.id.maleButton)
        catButton = findViewById(R.id.femaleButton)
        adoptButton = findViewById(R.id.adoptButton)
        layoutRoot = findViewById(R.id.layoutRoot)

        // On Click Listener and Intent to next Activity
        adoptButton.setOnClickListener {

            // Only proceed if either dog or cat is chosen
            if (petSelection != null){
                myPet = Pet(petSelection!!)
                val myIntent = Intent(this, Details::class.java)
                myIntent.putExtra("Pet", myPet)
                startActivity(myIntent)
            }

            else{
                val petSnackbar = Snackbar.make(layoutRoot,"Please Select a Pet" , Snackbar.LENGTH_SHORT,)
                petSnackbar.show()
            }

        }
    }

    // Change background (for user feedback) and update selected animal type
    fun selectDog(view: android.view.View){
        backGroundIdDog = (R.drawable.rounded_filled)
        backGroungIdCat = (R.drawable.rounded_corners)

        petSelection = PetType.DOG
        updateView()
    }

    fun selectCat(view: android.view.View){
        backGroundIdDog = (R.drawable.rounded_corners)
        backGroungIdCat = (R.drawable.rounded_filled)
        petSelection = PetType.CAT
        updateView()
    }

    // Update View for Saved State
    fun updateView(){
        dogButton.setBackgroundResource(backGroundIdDog!!)
        catButton.setBackgroundResource(backGroungIdCat!!)
    }

    // Save State on Rotation
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        backGroundIdDog?.let {outState.putInt("ImageDog", it)}
        backGroungIdCat?.let {outState.putInt("ImageCat", it)}
        petSelection?.let { outState.putSerializable("Selection", it) }
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        backGroundIdDog = savedInstanceState.getInt("ImageDog")
        backGroungIdCat = savedInstanceState.getInt("ImageCat")
        petSelection = savedInstanceState.getSerializable("Selection") as PetType?
        updateView()
    }
}