package com.example.petadopt

import java.io.Serializable

data class Pet (var petType: PetType): Serializable
{

    var name = ""
    var favoriteFood = ""
    var male = false
    var female = false
    var imageResource: Int? = null

    init{
        setDefaultName()
        determineFavoriteFood()
        determineImageResource()
    }

    fun setGender(isMale:Boolean){
        if(isMale){
            male = true
            female = false
        }
        else{
            male = false
            female = true
        }
    }

    private fun determineFavoriteFood(){
        when (petType){
            PetType.DOG -> {
                if(male){
                    favoriteFood = "Dog Bones"
                }
                else{
                    favoriteFood = "Treats"
                }
            }

            PetType.CAT -> {
                if(male){
                    favoriteFood = "Water"
                }
                else{
                    favoriteFood = "Milk"
                }
            }
        }
    }

    private fun determineImageResource(){
        when (petType){
            PetType.DOG -> {
                imageResource = R.drawable.dog
            }

            PetType.CAT -> {
                imageResource = R.drawable.cat
            }
        }
    }

    private fun setDefaultName(){
        when(petType){
            PetType.DOG -> {
                name = "Dog"
            }
            PetType.CAT -> {
                name = "Cat"
            }
        }
    }

}