package lorenzokorn.advanced_recyclerview_kotlin.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import lorenzokorn.advanced_recyclerview_kotlin.R
import lorenzokorn.advanced_recyclerview_kotlin.model.ColorAdapter
import lorenzokorn.advanced_recyclerview_kotlin.model.ColorItem

class MainActivity : AppCompatActivity() {

    private val colors = arrayListOf<ColorItem>()
    private val colorAdapter = ColorAdapter(colors) { colorItem -> onColorClick(colorItem) }
    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        initViewModel()
    }

    private fun initView() {
        rvColors.layoutManager =
            LinearLayoutManager(this@MainActivity, RecyclerView.VERTICAL, false)
        rvColors.adapter = colorAdapter
    }

    private fun initViewModel() {
        viewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)
        
        viewModel.colorItems.observe(this, Observer {
            colors.clear()
            colors.addAll(it)
            colorAdapter.notifyDataSetChanged()
        })

    }

    private fun onColorClick(colorItem: ColorItem) {
        Snackbar.make(rvColors, "This color is: ${colorItem.name}", Snackbar.LENGTH_SHORT).show()
    }
}
