package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar
import org.w3c.dom.Text


class MainActivity : AppCompatActivity() {

    lateinit var layoutRoot: ConstraintLayout
    lateinit var radioGroup: RadioGroup
    lateinit var messageText: TextView
    lateinit var gluten: Switch
    lateinit var checkbox1: CheckBox
    lateinit var checkbox2: CheckBox
    lateinit var checkbox3: CheckBox
    lateinit var checkbox4: CheckBox
    lateinit var locationButton: Button
    lateinit var reviewTextView: TextView
    lateinit var spinner: Spinner
    private var mytacoShop = tacoShop()
    private var selectedTacoShop = 0
    var fillingId = -1

    // Request Code
    private var REQUEST_CODE = 1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        layoutRoot = findViewById<ConstraintLayout>(R.id.root_layout)
        radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        messageText = findViewById<TextView>(R.id.tacoDescription)
        gluten = findViewById<Switch>(R.id.glutenSwitch)
        checkbox1 = findViewById<CheckBox>(R.id.checkBox)
        checkbox2 = findViewById<CheckBox>(R.id.checkBox2)
        checkbox3 = findViewById<CheckBox>(R.id.checkBox3)
        checkbox4 = findViewById<CheckBox>(R.id.checkBox4)
        locationButton = findViewById<Button>(R.id.locationButton)
        reviewTextView = findViewById<TextView>(R.id.reviewTextView)
        spinner = findViewById<Spinner>(R.id.spinner)


        // Event Listener
        locationButton.setOnClickListener{
            selectedTacoShop = spinner.selectedItemPosition
            mytacoShop.suggestMenuItem(selectedTacoShop)
            Log.i("Shop Suggested:", mytacoShop.name)
            Log.i("url", mytacoShop.url)

            // Create Intent
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("tacoShopName", mytacoShop.name)
            intent.putExtra("tacoShopUrl", mytacoShop.url)

            startActivityForResult(intent, REQUEST_CODE)
        }
    }

    override fun onBackPressed() {
        val data = Intent()
        data.putExtra("Feedback:", feedbackEditText.text)
        super.onBackPressed()
        finish()
    }


    fun createTaco(view: android.view.View) {
        var tempString = ""
        var toppingsList = ""
        var glutenText = ""
        fillingId = radioGroup.checkedRadioButtonId
        val location = findViewById<Spinner>(R.id.spinner)
        if (fillingId == -1){
            val fillingSnackbar = Snackbar.make(layoutRoot,"Please Select a Filling:" , Snackbar.LENGTH_SHORT,)
            fillingSnackbar.show()
        }
        else{
            Log.i("step:", "1")
            var filling = findViewById<RadioButton>(fillingId).text
            Log.i("step:", "2")

            if (checkbox1.isChecked){
                toppingsList += "with " + checkbox1.text
                Log.i("step:", "3")

            }
            if (checkbox2.isChecked){
                toppingsList += "with " + checkbox2.text
                Log.i("step:", "4")
            }
            if (checkbox3.isChecked){
                toppingsList += "with " + checkbox3.text
                Log.i("step:", "5")
            }
            if (checkbox4.isChecked){
                toppingsList += "with " + checkbox4.text
                Log.i("step:", "6")
            }

            if (gluten.isChecked()){
                glutenText = "Gluten Free"
                Log.i("step:", "7")
            }


            tempString = "You'd like ${glutenText} ${filling} tacos"
            Log.i("step:", "8")


//            val image = findViewById<ImageView>(R.id.imageView)
//            image.setImageResource(R.drawable.tacos2)
            messageText.text = "${tempString} ${toppingsList} at ${location.selectedItem}"
            Log.i("step:", "9")

        }
    }
}

