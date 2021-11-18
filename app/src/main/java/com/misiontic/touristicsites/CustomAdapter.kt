package com.misiontic.touristicsites

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter: RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    val titles = arrayOf(
        "Dubái creek, Zona Antigua",
        "Dubai Mall",
        "Fuente de Dubai",
        "Safari en el Desierto Dedilay")

    val ingresa = arrayOf(
        "Ingresa",
        "Ingresa",
        "Ingresa",
        "Ingresa")

    val images = arrayOf(
        R.drawable.dubai_1,
        R.drawable.dubai_2,
        R.drawable.dubai_3,
        R.drawable.dubai_4)



    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v= LayoutInflater.from(viewGroup.context).inflate(R.layout.card_layout, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.itemTitle.text=titles[i]
        viewHolder.itemIngresa.text=ingresa[i]
        viewHolder.itemImage.setImageResource(images[i])
    }

    override fun getItemCount(): Int {
        return titles.size
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var itemImage: ImageView
        var itemTitle: TextView
        var itemIngresa: TextView

        init {
            itemImage = itemView.findViewById(R.id.item_image)
            itemTitle = itemView.findViewById(R.id.item_title)
            itemIngresa = itemView.findViewById(R.id.item_Ingresa)

        }

    }




}