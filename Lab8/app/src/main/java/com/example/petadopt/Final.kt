package com.example.petadopt

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

class Final : AppCompatActivity() {

    private var myPet: Pet? = null
    lateinit var petImageView: ImageView
    lateinit var petInfo: TextView
    lateinit var pronoun: String
    lateinit var browseButton: Button
    lateinit var adoptButton: Button
    lateinit var view: ConstraintLayout
    var petAdoptUrl = "https://www.petsmart.com/adoption/people-saving-pets/ca-adoption-landing.html"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final)

        petImageView = findViewById(R.id.petImage)
        petInfo = findViewById(R.id.infoText)
        browseButton = findViewById(R.id.browsePets)
        adoptButton = findViewById(R.id.adoptAgain)
        view = findViewById(R.id.view)

        val bundle = this.intent.extras
        if (bundle != null) {
            myPet.let { myPet = bundle.getSerializable("Pet") as Pet? }
        }

        if (myPet!!.male){
            pronoun = "She"
        }
        else{
            pronoun = "He"
        }

        petInfo.text = "\n You adopted ${myPet!!.name}! ${myPet!!.name} loves pets and playing. ${pronoun} also loves ${myPet!!.favoriteFood}. Have fun with your new pet!"
        myPet!!.imageResource?.let { petImageView.setImageResource(it) }

        
        // Implicit Intent
        browseButton.setOnClickListener {

            val intentBrowse = Intent()
                intentBrowse.action = Intent.ACTION_VIEW
                intentBrowse.data = Uri.parse(petAdoptUrl)
                startActivity(intentBrowse)

        }

        // Explicit Intent
        adoptButton.setOnClickListener {
            val myIntent = Intent(this, MainActivity::class.java)
            startActivity(myIntent)
        }
    }
}