package lorenzokorn.advanced_recyclerview_kotlin

import lorenzokorn.advanced_recyclerview_kotlin.model.ColorItem

class ColorRepository {
    fun getColorItems(): List<ColorItem> {
        return arrayListOf(
            ColorItem("FF00DD", "Pink"),
            ColorItem("000000", "Black"),
            ColorItem("FF0000", "Red"),
            ColorItem("0000FF", "Blue"),
            ColorItem("FFFF00", "Yellow"),
            ColorItem("008000", "Green")
        )
    }
}