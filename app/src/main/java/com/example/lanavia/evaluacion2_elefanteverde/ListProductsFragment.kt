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
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Spinner
import android.widget.TextView
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

        var v : View = inflater.inflate(R.layout.fragment_list_products,container,false)

        var lvProductos: ListView = v.findViewById<ListView>(R.id.lvProductos)

        val customSQL  = CustomSQL(miContexto!!,"ProductosSuper",null,1)
        val lista = customSQL.getProductos()

        return v

    }

    class CustomAdapter(val miContext: Context, val recurso: Int, val lista: ArrayList<Product>) :
        ArrayAdapter<Product>(miContext, recurso, lista) {
        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {


            var view: View = LayoutInflater.from(miContext).inflate(recurso, null)

            var nombre: TextView = view.findViewById(R.id.lblnombre)
            var stock: TextView = view.findViewById(R.id.lblstock)
            var precionormal: TextView = view.findViewById(R.id.lblnormalprice)
            var categoria: TextView = view.findViewById(R.id.lblcategory)

            nombre.text = lista[position].name.toString()
            stock.text = lista[position].stock.toString()
            precionormal.text = lista[position].normalPrice.toString()
            categoria.text = lista[position].category.toString()

            return view
        }

    }
}