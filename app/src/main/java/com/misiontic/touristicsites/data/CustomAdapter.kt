package com.misiontic.touristicsites.data

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.misiontic.touristicsites.R

class CustomAdapter(private val sites: List<ModelSites>, private val context: Context, val click: (ModelSites?) -> Unit) :
    RecyclerView.Adapter<CustomAdapter.SitesHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SitesHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return SitesHolder(layoutInflater.inflate(R.layout.card_layout, parent, false), context)
    }

    override fun onBindViewHolder(holder: SitesHolder, position: Int) {
        holder.render(sites[position])
    }

    override fun getItemCount(): Int = sites.size

    inner class SitesHolder(private val view: View, private val context: Context) : RecyclerView.ViewHolder(view) {
        private var city : ModelSites? = null
        init {
            view.setOnClickListener {
                click(city)
            }
        }

        @SuppressLint("SetTextI18n")
        fun render(site: ModelSites) {
            city = site
            view.findViewById<TextView>(R.id.item_title).text = site.titulo
            view.findViewById<TextView>(R.id.item_description).text = site.descripcion_corta
            view.findViewById<TextView>(R.id.item_score).text = "Puntaje: " + site.score
            Glide.with(context).load(site.ruta_imagen).into(view.findViewById(R.id.item_image))
        }
    }
}