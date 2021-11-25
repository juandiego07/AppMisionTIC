package com.misiontic.touristicsites

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class CustomAdapter(val sites: List<ModelSites>, val context: Context, val click: (ModelSites?) -> Unit) :
    RecyclerView.Adapter<CustomAdapter.SitesHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomAdapter.SitesHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return SitesHolder(layoutInflater.inflate(R.layout.card_layout, parent, false), context)
    }

    override fun onBindViewHolder(holder: CustomAdapter.SitesHolder, position: Int) {
        holder.render(sites[position])
    }

    override fun getItemCount(): Int = sites.size

    inner class SitesHolder(val view: View, val context: Context) : RecyclerView.ViewHolder(view) {
        private var city : ModelSites? = null
        init {
            view.setOnClickListener {
                click(city)
            }
        }

        fun render(site: ModelSites) {
            city = site
            view.findViewById<TextView>(R.id.item_title).text = site.titulo
            view.findViewById<TextView>(R.id.item_description).text = site.descripcion_corta
            view.findViewById<TextView>(R.id.item_score).text = "Puntaje: " + site.score
            Glide.with(context).load(site.ruta_imagen).into(view.findViewById(R.id.item_image))
        }
    }
}