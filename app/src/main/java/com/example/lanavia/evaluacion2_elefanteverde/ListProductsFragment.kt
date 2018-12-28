package com.example.lanavia.evaluacion2_elefanteverde


//GridLayout se encarga de posicionar los elementos en la lista
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.ListView
import android.widget.TextView


class ListProductsFragment : Fragment() {

    var customSQL = null

    var miContexto: Context? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var v: View = inflater.inflate(R.layout.fragment_list_products, container, false)
        miContexto = activity
        var customSQL = CustomSQL(miContexto!!, "ProductosSuper", null, 1)
        var lvProductos: ListView = v.findViewById<ListView>(R.id.lvProductos)
        val listaProductosArray: ArrayList<Producto> = customSQL.getProductos()
        var adaptador = CustomAdapter(miContexto!!,R.layout.lista_productos_layout,listaProductosArray)
        lvProductos.adapter=adaptador
        return v
    }
}

class CustomAdapter(var miContexto : Context,
                    var recurso : Int,
                    var listaProductosArray:ArrayList<Producto>) : ArrayAdapter<Producto>(miContexto, recurso, listaProductosArray) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {


        var v : View = LayoutInflater.from(miContexto).inflate(recurso, null)
        var fondoLayOutItems = v.findViewById<LinearLayout>(R.id.layListaProductos)

        var nombre: TextView = v.findViewById(R.id.lblnombre)
        var cantidad: TextView = v.findViewById(R.id.lblcantidad)
        var categoria: TextView = v.findViewById(R.id.lblcategoria)
        var precionormal: TextView = v.findViewById(R.id.lblprecionormal)
        var precioIVA : TextView = v.findViewById(R.id.lblIva)
        var precioUSD : TextView = v.findViewById(R.id.lblDolar)


        nombre.text = listaProductosArray[position].nombre
        cantidad.text = listaProductosArray[position].cantidad.toString()
        categoria.text = listaProductosArray[position].categoria
        precionormal.text = listaProductosArray[position].precio.toString()
        precioIVA.text  = "$ " + listaProductosArray[position].precioIVA.toInt().toString() + " CLP"
        precioUSD.text = "$ " + listaProductosArray[position].precioUSD.toInt().toString() + " USD"



        var stock = cantidad.text.toString().toInt()

        if (stock < 5) {
            fondoLayOutItems.setBackgroundColor(miContexto.resources.getColor(R.color.red))
        }   else if (stock in 6..19) {
            fondoLayOutItems.setBackgroundColor(miContexto.resources.getColor(R.color.yellow))
        }else {
            fondoLayOutItems.setBackgroundColor(miContexto.resources.getColor(R.color.green))
        }
        return v
    }
}