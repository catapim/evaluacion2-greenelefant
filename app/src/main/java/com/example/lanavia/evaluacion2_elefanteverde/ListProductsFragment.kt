package com.example.lanavia.evaluacion2_elefanteverde


import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

//GridLayout se encarga de posicionar los elementos en la lista
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Spinner
import kotlinx.android.synthetic.main.fragment_list_products.*
import kotlinx.android.synthetic.main.fragment_list_products.view.*


/**
 * Fragmento utilizado para listar los productos
 *
 */
class ListProductsFragment : Fragment() {

    var miContexto:Context?=null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view : View = inflater.inflate(R.layout.fragment_list_products, container, false)
        val activity = activity
        val recyclerView = view.findViewById(R.id.rclyListProducts) as RecyclerView
        recyclerView.layoutManager = GridLayoutManager(activity,2)
        recyclerView.adapter = ListProductsAdapter()
        return view
    }
}
