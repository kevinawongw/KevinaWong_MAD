package com.example.petadopt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar

class Details : AppCompatActivity() {

    // Initialize Variables
    lateinit var petName: EditText
    lateinit var maleButton: ImageButton
    lateinit var femaleButton: ImageButton
    lateinit var nextButton: Button
    lateinit var detailLayout: ConstraintLayout
    var name = ""
    var myPet: Pet? = null
    var isMale: Boolean? = null
    var maleBackground: Int? = (R.drawable.rounded_corners)
    var femaleBackground: Int? = (R.drawable.rounded_corners)

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        // Get Pet from previous Activity
        val bundle = this.intent.extras
        if (bundle != null) {
            myPet.let { myPet = bundle.getSerializable("Pet") as Pet? }
        }

        // Define and Find Views
        petName = findViewById(R.id.petName)
        maleButton = findViewById(R.id.maleButton)
        femaleButton = findViewById(R.id.femaleButton)
        nextButton = findViewById(R.id.nextButton)
        detailLayout = findViewById(R.id.detailLayout)

        // OnClick Listener for the next Activity
        nextButton.setOnClickListener {

            // Update the Pet's name if the user would like to (Default: "Dog" and "Cat")
            name = petName.text.toString()

            if (name.length > 0){
                myPet?.name = name
            }

            // Ensure that a gender for the pet is selected without moving on
            if (isMale == null){
                val petSnackbar = Snackbar.make(detailLayout,"Please Select a Gender" , Snackbar.LENGTH_SHORT,)
                petSnackbar.show()
            }
            else{
                val myIntent = Intent(this, Final::class.java)
                myIntent.putExtra("Pet", myPet)
                startActivity(myIntent)
            }
        }
    }

    // Update Pet Object's Gender and change background for feedback
    fun selectMale(view: android.view.View){
        maleBackground = (R.drawable.rounded_filled)
        femaleBackground = (R.drawable.rounded_corners)
        isMale = true
        myPet?.setGender(true)
        updateView()
    }

    fun selectFemale(view: android.view.View){
        femaleBackground = (R.drawable.rounded_filled)
        maleBackground = (R.drawable.rounded_corners)
        myPet?.setGender(false)
        isMale = false
        updateView()
    }

    fun updateView(){
        maleButton.setBackgroundResource(maleBackground!!)
        femaleButton.setBackgroundResource(femaleBackground!!)
    }

    // Save State on Rotation
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        maleBackground?.let {outState.putInt("ImageMale", it)}
        femaleBackground?.let {outState.putInt("ImageFemale", it)}
        isMale?.let { outState.putBoolean("Gender", it) }
        outState.putString("Name", name)


        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        name = savedInstanceState.getString("Name", "")
        maleBackground = savedInstanceState.getInt("ImageMale")
        femaleBackground = savedInstanceState.getInt("ImageFemale")
        isMale = savedInstanceState.getBoolean("Gender")
        updateView()
    }
}