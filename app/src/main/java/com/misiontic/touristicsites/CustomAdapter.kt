package com.misiontic.touristicsites

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class CustomAdapter(val sites: List<ModelSites>, val context: Context) : RecyclerView.Adapter<CustomAdapter.SitesHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomAdapter.SitesHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return SitesHolder(layoutInflater.inflate(R.layout.card_layout, parent, false), context)
    }

    override fun onBindViewHolder(holder: CustomAdapter.SitesHolder, position: Int) {
        holder.render(sites[position])
    }

    override fun getItemCount(): Int = sites.size

    class SitesHolder(val view: View, val context: Context) : RecyclerView.ViewHolder(view) {

        fun render(site: ModelSites, ) {
            view.findViewById<TextView>(R.id.item_title).text = site.titulo
            view.findViewById<TextView>(R.id.item_description).text = site.descripcion_corta
//            Glide.with(context).load("https://as1.ftcdn.net/v2/jpg/01/02/05/94/1000_F_102059484_guEkhlGRr23lZhGb2qYuko8aKav0gQ7D.jpg").into(view.findViewById(R.id.item_image))
            Glide.with(context).load(site.ruta_imagen).into(view.findViewById(R.id.item_image))
//            Glide.with(context).load("@drawable/dubai_5").into(view.findViewById(R.id.item_image))
        }
    }
}

//class CustomAdapter: RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
//
//    val images = arrayOf(
//        R.drawable.dubai_1,
//        R.drawable.dubai_2,
//        R.drawable.dubai_3,
//        R.drawable.dubai_4,
//        R.drawable.dubai_5)
//
//    val titles = arrayOf(
//        "Dubái creek, Zona Antigua",
//        "Dubái Mall",
//        "Fuente de Dubái",
//        "Safari en el Desierto Dedilay",
//        "Playa Burj Al Arab")
//
//    val description = arrayOf(
//        "Dubái Creek es el corazón de la ciudad",
//        "El Dubái Mall es el Centro Comercial más grande del mundo",
//        "No puedes perderte el show de aguas danzantes de la Fuente de Dubái",
//        "Recorre las arenas rojizas en un Safari por el Desierto de Dubái",
//        "Incursiona en el surf con las olas de la Playa Burj Al Arab")
//
//    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
//        val v= LayoutInflater.from(viewGroup.context).inflate(R.layout.card_layout, viewGroup, false)
//        return ViewHolder(v)
//    }
//
//    override fun onBindViewHolder(objeto: ViewHolder, i: Int) {
//        objeto.itemImage.setImageResource(images[i])
//        objeto.itemTitle.text=titles[i]
//        objeto.itemDescription.text=description[i]
//    }
//
//    override fun getItemCount(): Int {
//        return titles.size
//    }
//
//    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
//        var itemImage: ImageView
//        var itemTitle: TextView
//        var itemDescription: TextView
//
//        init {
//            itemImage = itemView.findViewById(R.id.item_image)
//            itemTitle = itemView.findViewById(R.id.item_title)
//            itemDescription = itemView.findViewById(R.id.item_description)
//
//        }
//
//    }
//}