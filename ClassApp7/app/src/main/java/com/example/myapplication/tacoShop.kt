package com.example.myapplication

data class tacoShop(var name: String = "", var url: String = ""){

    fun suggestMenuItem (position: Int){
        setTacoShopName(position)
        setTacoShopUrl(position)
    }

    private fun setTacoShopUrl(position: Int) {
        when (position){
            0 -> name = "Cheesy Gordita Crunch"
            1 -> name = "Steak Burrito Bowl"
            2 -> name = "Chicken Queso Burrito"
            else -> name = "Choose Another"
        }
    }

    private fun setTacoShopName(position: Int){
        when (position){
            0 -> url = "https://www.tacobell.com/food/specialties/cheesy-gordita-crunch"
            1 -> url = "https://www.chipotle.com/order/build/burrito-bowl"
            2 -> url = "https://www.qdoba.com/menu/chicken-queso-burrito"

            else -> url = "https://www.google.com/search?q=taco+shops+in+boulder&oq=taco+shop+in+bou&aqs=chrome.1.69i57j0i22i30l6.5878j0j4&sourceid=chrome&ie=UTF-8"
        }
    }




}