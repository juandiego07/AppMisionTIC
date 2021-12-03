package com.misiontic.touristicsites

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class PoiFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_poi, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val site = null
        site?.let(this::detailSite)

    }


    private fun detailSite(site: Intent) {

        val intent = Intent(requireContext(), Detail_fragment::class.java).apply {
            view?.findViewById<TextView>(R.id.tvDubai)?.text = site.getStringExtra("titulo")
            view?.findViewById<TextView>(R.id.tv_detalle)?.text = site.getStringExtra("descripcion")
            view?.findViewById<TextView>(R.id.tv_detalle2)?.text = site.getStringExtra("ubicacion")
            view?.findViewById<TextView>(R.id.tv_detalle3)?.text = site.getStringExtra("tiempo")
            view?.findViewById<TextView>(R.id.sitios)?.text = site.getStringExtra("sitios")
        }
    }



}