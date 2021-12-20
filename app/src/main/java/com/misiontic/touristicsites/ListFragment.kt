package com.misiontic.touristicsites

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListFragment : Fragment() {

    private lateinit var listViewModel: ListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listViewModel = ViewModelProvider(this)[ListViewModel::class.java]

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)

        listViewModel.getSitesList().observe(viewLifecycleOwner, {
            val adapter = CustomAdapter(it, requireContext()) { site ->
                detailSite(site)
            }
            recyclerView.layoutManager = LinearLayoutManager(requireContext())
            recyclerView.adapter = adapter
        })

        val button = view.findViewById<ImageButton>(R.id.ib_config)
        button.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_list_Fragment2_to_preferenceFragment)
        }

    }

    private fun detailSite(site: ModelSites?) {

        val intent = Intent(requireContext(), Detail_fragment::class.java).apply {
            putExtra("titulo", "${site?.titulo}")
            putExtra("descripcion", "${site?.descripcion}")
            putExtra("descripcion_corta", "${site?.descripcion_corta}")
            putExtra("ubicacion", "${site?.ubicacion}")
            putExtra("tiempo", "${site?.tiempo}")
            putExtra("sitios", "${site?.sitios}")
            putExtra("ruta_imagen", "${site?.ruta_imagen}")
            putExtra("score", "${site?.score}")
            putExtra("lat", "${site?.lat}")
            putExtra("long", "${site?.long}")
        }
        startActivity(intent)
    }
}