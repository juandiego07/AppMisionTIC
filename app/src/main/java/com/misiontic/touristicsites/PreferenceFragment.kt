package com.misiontic.touristicsites

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController

class PreferenceFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =inflater.inflate(R.layout.fragment_preference, container, false)

        //val button = view.findViewById<Button>(R.id.ib_back)
        // button.setOnClickListener {
        //Navigation.findNavController(view).navigate(R.id.action_preferenceFragment_to_list_Fragment2)

        //}
        return view
    }



}