package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun createTaco(view: android.view.View) {
        val layoutRoot = findViewById<ConstraintLayout>(R.id.root_layout)
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val fillingId = radioGroup.checkedRadioButtonId
        val messageText = findViewById<TextView>(R.id.tacoDescription)
        val gluten = findViewById<Switch>(R.id.glutenSwitch)
        val checkbox1 = findViewById<CheckBox>(R.id.checkBox)
        val checkbox2 = findViewById<CheckBox>(R.id.checkBox2)
        val checkbox3 = findViewById<CheckBox>(R.id.checkBox3)
        val checkbox4 = findViewById<CheckBox>(R.id.checkBox4)
        var tempString = ""
        var toppingsList = ""
        var glutenText = ""

        val location = findViewById<Spinner>(R.id.spinner)
        if (fillingId == -1){
            val fillingSnackbar = Snackbar.make(layoutRoot,"Please Select a Filling:" , Snackbar.LENGTH_SHORT,)
            fillingSnackbar.show()
        }
        else{
            val filling = findViewById<RadioButton>(fillingId).text
            if (checkbox1.isChecked){
                toppingsList += "with " + checkbox1.text
            }
            if (checkbox2.isChecked){
                toppingsList += "with " + checkbox2.text

            }
            if (checkbox3.isChecked){
                toppingsList += "with " + checkbox3.text

            }
            if (checkbox4.isChecked){
                toppingsList += "with " + checkbox4.text
            }

            if (gluten.isChecked()){
                glutenText = "Gluten Free"
            }
            tempString = "You'd like ${glutenText} ${filling} tacos"

            val image = findViewById<ImageView>(R.id.imageView)
            image.setImageResource(R.drawable.tacos2)
            messageText.text = "${tempString} ${toppingsList} at ${location.selectedItem}"
        }
    }
}

