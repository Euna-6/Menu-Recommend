package com.example.menurecommend

data class MenuItem(val menu : String) {
    companion object {
        val menuList = arrayListOf(
            MenuItem("파스타"),
            MenuItem("라멘"),
            MenuItem("비빔면"),
            MenuItem("쫄면")
        )
    }
}