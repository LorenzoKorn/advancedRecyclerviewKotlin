package lorenzokorn.advanced_recyclerview_kotlin.model

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_color.view.*
import lorenzokorn.advanced_recyclerview_kotlin.R

class ColorAdapter(private var colors: List<ColorItem>) :
    RecyclerView.Adapter<ColorAdapter.ViewHolder>() {

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_color, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return colors.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(colors[position])
    }

    inner class ViewHolder(itemView:View): RecyclerView.ViewHolder(itemView) {
        fun bind(color: ColorItem) {
            Glide.with(context).load(color.getImageUrl()).into(itemView.color_image)
        }
    }
}