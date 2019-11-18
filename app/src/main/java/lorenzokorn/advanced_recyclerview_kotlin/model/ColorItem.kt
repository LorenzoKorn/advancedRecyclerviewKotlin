package lorenzokorn.advanced_recyclerview_kotlin.model

class ColorItem(
    var hex: String,
    var name: String
) {
    // use of inline variable
    fun getImageUrl() = "http://singlecolorimage.com/get/$hex/1080x1080"
}