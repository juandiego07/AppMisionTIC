package com.misiontic.touristicsites

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
// import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso
import androidx.recyclerview.widget.RecyclerView

class SitesAdapter(val sites: List<DataSites>) : RecyclerView.Adapter<SitesAdapter.SitesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SitesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return SitesViewHolder(layoutInflater.inflate(R.layout.sites_list, parent, false))
    }

    override fun onBindViewHolder(holder: SitesViewHolder, position: Int) {
       holder.render(sites[position])
    }

    override fun getItemCount(): Int = sites.size

    class SitesViewHolder (val view:View) : RecyclerView.ViewHolder(view) {
        fun render( site: DataSites) {
            view.findViewById<TextView>(R.id.tvNombre).text = site.nombre
            view.findViewById<TextView>(R.id.tvDescripcion).text = "Descripción: "+site.resumen
            view.findViewById<TextView>(R.id.tvRanking).text = site.ranking
            Picasso.get().load(site.imagen).into(view.findViewById<ImageView>(R.id.ivImg))
            //Glide.with(context)
            //    .load(site.imagen)
            //    .into(view.findViewById<ImageView>(R.id.ivImg))
        }

    }
}