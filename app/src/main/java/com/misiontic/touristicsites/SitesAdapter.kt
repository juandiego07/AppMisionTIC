package com.misiontic.touristicsites

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class SitesAdapter(val sites: List<DataSites>) : RecyclerView.Adapter<SitesAdapter.SitesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SitesViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: SitesViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int = sites.size

    class SitesViewHolder (view: View) : RecyclerView.ViewHolder(view) {

    }
}