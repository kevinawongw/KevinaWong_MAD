package com.example.lab7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    var message: String = ""
    var tempString: String = ""
    var veganText: String = ""
    var toppingsList: String = ""
    var foodName: String = ""
    var imageId: Int? = null


    lateinit var layoutRoot: ConstraintLayout
    lateinit var radioGroup: RadioGroup
    lateinit var messageText: TextView
    lateinit var gluten: Switch
    lateinit var checkbox1: CheckBox
    lateinit var checkbox2: CheckBox
    lateinit var checkbox3: CheckBox
    lateinit var checkbox4: CheckBox
    lateinit var checkbox5: CheckBox
    lateinit var checkbox6: CheckBox
    lateinit var veganSwitch: Switch
    lateinit var image: ImageView
    lateinit var drink: Spinner


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get Views
        layoutRoot = findViewById<ConstraintLayout>(R.id.root_layout)
        radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        messageText = findViewById<TextView>(R.id.foodText)
        gluten = findViewById<Switch>(R.id.veganSwitch)
        checkbox1 = findViewById<CheckBox>(R.id.checkBox1)
        checkbox2 = findViewById<CheckBox>(R.id.checkBox2)
        checkbox3 = findViewById<CheckBox>(R.id.checkBox3)
        checkbox4 = findViewById<CheckBox>(R.id.checkBox4)
        checkbox5 = findViewById<CheckBox>(R.id.checkBox5)
        checkbox6 = findViewById<CheckBox>(R.id.checkBox6)
        veganSwitch = findViewById<Switch>(R.id.veganSwitch)
        image = findViewById<ImageView>(R.id.foodImage)
        drink = findViewById<Spinner>(R.id.drinkSpinner)

    }

    fun createMeal(view: android.view.View) {
        val mealID = radioGroup.checkedRadioButtonId

        if (mealID == -1){
            val fillingSnackbar = Snackbar.make(layoutRoot,"Please Select a Meal Time:" , Snackbar.LENGTH_SHORT,)
            fillingSnackbar.show()
        }
        else{
            if((mealID == R.id.radio1) && (veganSwitch.isChecked)){
                foodName = "Jam & Toast"
                imageId = R.drawable.breakfast_vegan
            }
            else if((mealID == R.id.radio1) && !veganSwitch.isChecked){
                foodName = "Eggs and Sausages"
                imageId = R.drawable.breakfast_nonvegan

            }

            else if((mealID == R.id.radio2) && (veganSwitch.isChecked)){
                foodName = "Chocolate Croissant"
                imageId = R.drawable.lunch_vegan

            }
            else if((mealID == R.id.radio2) && !veganSwitch.isChecked){
                foodName = "Burrito"
                imageId = R.drawable.lunch_nonvegan

            }

            else if((mealID == R.id.radio3) && (veganSwitch.isChecked)){
                foodName = "Fruit Salad"
                imageId = R.drawable.dinner_vegan

            }
            else if((mealID == R.id.radio3) && !veganSwitch.isChecked){
                foodName = "Steak"
                imageId = R.drawable.dinner_nonvegan

            }

            if (checkbox1.isChecked){
                toppingsList += " with " + checkbox1.text
            }
            if (checkbox2.isChecked){
                toppingsList += " with " + checkbox2.text

            }
            if (checkbox3.isChecked){
                toppingsList += " with " + checkbox3.text

            }
            if (checkbox4.isChecked){
                toppingsList += " with " + checkbox4.text
            }

            if (checkbox5.isChecked){
                toppingsList += " with " + checkbox5.text
            }

            if (checkbox6.isChecked){
                toppingsList += " with " + checkbox6.text
            }

            if (veganSwitch.isChecked()){
                veganText = "Vegan"
            }


            tempString = "You should eat ${veganText} ${foodName}${toppingsList}"

            message = "${tempString} with ${drink.selectedItem}"

            updateUI()
        }

    }

    fun updateUI() {
        messageText.text = message
        imageId?.let{image.setImageResource(it)}
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("Message", message)
        imageId?.let {outState.putInt("Image", it)}
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        message = savedInstanceState.getString("Message", "")
        imageId = savedInstanceState.getInt("Image")
        updateUI()
    }
}