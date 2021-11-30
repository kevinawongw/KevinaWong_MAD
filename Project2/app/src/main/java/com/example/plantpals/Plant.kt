package com.example.plantpals

import android.util.Log
import java.io.Serializable

// Plant Class!
data class Plant (var plantType: PlantType, var name: String): Serializable
{
    // Unparameterized variables that need to be initialized

    var curStage: Int = 1
    var totalStage: Int = -1
    var numWaterInStage: Int = 0
    var totalWater: Int = -1
    var numFert: Int = 0
    var totalFert: Int = -1
    var numHug: Int = 0
    var totalHug: Int = -1
    var numPest: Int = 0
    var totalPest: Int = -1
    var alive: Boolean = true
    var waterPercentage: Double = 0.0
    var stars: Int = 0
    var deathBy: DeathBy? = null

    // Functions that help initialize variables based on which plant
     init {
         determineTotals()
         chooseImage()
     }

    // Initialization helper
    // Different values based on plant type as each plant has a different lifecycle
    private fun determineTotals() {
        when (plantType) {
            PlantType.TULIP -> {
                totalStage = 5
                totalWater = 12
                totalPest = 5
                totalHug = 5
                totalFert = 5
            }
            PlantType.TREE -> {
                totalStage = 6
                totalWater = 14
                totalPest = 6
                totalHug = 6
                totalFert = 6
            }
            PlantType.GARLIC -> {
                totalStage = 4
                totalWater = 8
                totalPest = 4
                totalHug = 4
                totalFert = 4
            }
        }
    }

    // Hug :)
    fun hug(){
        numHug++

        if (numHug > totalHug){
            alive = false
            deathBy = DeathBy.HUGS
            Log.i("Killed", "Killed w/ Hugs :(")
        }
    }

    // Fertilize
    fun fertilize(){
        numFert++

        if (numFert > totalFert){
            alive = false
            deathBy = DeathBy.FERTILIZER
            Log.i("Killed", "Killed w/ Fertilizer :(")
        }
    }

    // Pesticide
    fun pesticide(){
        numPest++

        if (numPest > totalPest){
            alive = false
            deathBy = DeathBy.PESTICIDE
            Log.i("Killed", "Killed w/ Pesticide :(")
        }
    }

    // Water
    fun water(){
        numWaterInStage++
        if (numWaterInStage == 2){
            Log.i("Next Stage", "Stage: ${curStage}")
            nextStage()
        }
        updateWaterPerecentage()
    }

    fun nextStage(){
        numWaterInStage = 0
        curStage++
        if (curStage == totalStage){
            Log.i("Grown Plant", "Stage: ${curStage}")
        }
        chooseImage()
    }

    fun chooseImage(): Int{
        var imageID: Int = 0
        if (!alive){
            imageID = R.drawable.grave
        }
        else {
            when (plantType) {
                // Tulip
                PlantType.TULIP -> {
                    when (curStage) {
                        1 -> imageID = R.drawable.s1
                        2 -> imageID = R.drawable.s2
                        3 -> imageID = R.drawable.s3
                        4 -> imageID = R.drawable.s4
                        5 -> imageID = R.drawable.tulip
                    }
                }

                // Tree
                PlantType.TREE -> {
                    when (curStage) {
                        1 -> imageID = R.drawable.s1
                        2 -> imageID = R.drawable.s2
                        3 -> imageID = R.drawable.s3
                        4 -> imageID = R.drawable.s4
                        5 -> imageID = R.drawable.s5
                        6 -> imageID = R.drawable.appletree
                    }

                }

                // Garlic
                PlantType.GARLIC -> {
                    when (curStage) {
                        1 -> imageID = R.drawable.s1
                        2 -> imageID = R.drawable.s2
                        3 -> imageID = R.drawable.s3
                        4 -> imageID = R.drawable.garlic
                    }
                }
            }
        }
        return imageID
    }

    fun updateWaterPerecentage(): Double{
        if(curStage == totalStage){
            waterPercentage = 100.0
            return 100.0
        }
        else {
            var percentage: Double = 0.0
            var numerator: Double = (curStage.toDouble() * 2) + numWaterInStage.toDouble()
            percentage = numerator / totalWater
            waterPercentage = Math.round(percentage * 100).toDouble()
            return Math.round(percentage * 100).toDouble()
        }
    }

    fun getStars(){
        var totalLove = 0
        if (alive){
            when (plantType) {
                // Tulip
                PlantType.TULIP -> {
                    totalLove = numFert + numHug + numPest
                    when (totalLove){
                        in 0..4 -> stars = 1
                        in 5..9 -> stars = 2
                        in 10..15 -> stars = 3
                    }
                }

                // Tree
                PlantType.TREE -> {
                    totalLove = numFert + numHug + numPest
                    when (totalLove){
                        in 0..6 -> stars = 1
                        in 7..12 -> stars = 2
                        in 13..18 -> stars = 3
                    }
                }

                // Garlic
                PlantType.GARLIC -> {
                    totalLove = numFert + numHug + numPest
                    when (totalLove){
                        in 0..3 -> stars = 1
                        in 4..8 -> stars = 2
                        in 9..12 -> stars = 3
                    }
                }
            }
        }
        else{
            stars = 0
        }
    }

}