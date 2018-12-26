package com.example.lanavia.evaluacion2_elefanteverde


import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast



/**
 * A simple [Fragment] subclass.
 *
 */
class AllProductsFragment : Fragment() {

    var miContext:Context?=null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view:View= inflater.inflate(R.layout.fragment_all_products, container, false)
     //   Toast.makeText(miContext,"Fragmento allProducts",Toast.LENGTH_SHORT).show()
        return view
    }


}
