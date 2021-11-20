package com.misiontic.touristicsites

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter: RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    val images = arrayOf(
        R.drawable.dubai_1,
        R.drawable.dubai_2,
        R.drawable.dubai_3,
        R.drawable.dubai_4,
        R.drawable.dubai_5)

    val titles = arrayOf(
        "Dubái creek, Zona Antigua",
        "Dubái Mall",
        "Fuente de Dubái",
        "Safari en el Desierto Dedilay",
        "Playa Burj Al Arab")

    val description = arrayOf(
        "Dubái Creek es el corazón de la ciudad",
        "El Dubái Mall es el Centro Comercial más grande del mundo",
        "No puedes perderte el show de aguas danzantes de la Fuente de Dubái",
        "Recorre las arenas rojizas en un Safari por el Desierto de Dubái",
        "Incursiona en el surf con las olas de la Playa Burj Al Arab")

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v= LayoutInflater.from(viewGroup.context).inflate(R.layout.card_layout, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(objeto: ViewHolder, i: Int) {
        objeto.itemImage.setImageResource(images[i])
        objeto.itemTitle.text=titles[i]
        objeto.itemDescription.text=description[i]
    }

    override fun getItemCount(): Int {
        return titles.size
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var itemImage: ImageView
        var itemTitle: TextView
        var itemDescription: TextView

        init {
            itemImage = itemView.findViewById(R.id.item_image)
            itemTitle = itemView.findViewById(R.id.item_title)
            itemDescription = itemView.findViewById(R.id.item_description)

        }

    }




}