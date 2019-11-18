package lorenzokorn.advanced_recyclerview_kotlin.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import lorenzokorn.advanced_recyclerview_kotlin.ColorRepository
import lorenzokorn.advanced_recyclerview_kotlin.model.ColorItem

class MainActivityViewModel : ViewModel(){
    private val colorRepository = ColorRepository()

    val colorItems = MutableLiveData<List<ColorItem>>().apply {
        value = colorRepository.getColorItems()
    }
}