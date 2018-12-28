package com.example.lanavia.evaluacion2_elefanteverde

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class frag_registro : Fragment() {

    var miContexto: Context? = null
    var customSQL = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
        ): View? {
        // Inflate the layout for this fragment
        var v: View = inflater.inflate(R.layout.fragment_frag_registro, container, false)

        miContexto = activity

        var customSQL = CustomSQL(miContexto!!, "ProductosSuper", null, 1)

        var btnSave = v.findViewById<Button>(R.id.btnGuardar)

        btnSave.setOnClickListener{

            var nombre = v.findViewById<EditText>(R.id.editNombre).text.toString()
            var cantidad = v.findViewById<EditText>(R.id.editCantidad).text.toString()
            var categoria = v.findViewById<EditText>(R.id.editCategoria).text.toString()
            var precionormal = v.findViewById<EditText>(R.id.editPrecioNormal).text.toString()

            if (nombre.length == 0 || cantidad.length == 0 || categoria.length == 0 || precionormal.length == 0 ) {
                Toast.makeText(miContexto,"Plz que no quede ningun campo en blanco", Toast.LENGTH_LONG).show()
            } else
            {
                customSQL.insertar(nombre,cantidad,categoria,precionormal.toInt(),null)
            }

        }
        return v
    }
}


