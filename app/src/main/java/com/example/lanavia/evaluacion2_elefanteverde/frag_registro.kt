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


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
        ): View? {
        // Inflate the layout for this fragment
        val v: View = inflater.inflate(R.layout.fragment_frag_registro, container, false)

        miContexto = activity

        var customSQL = CustomSQL(this.miContexto!!, "ProductosSuper", null, 1)

        var btnSave = v.findViewById<Button>(R.id.btnGuardar)

        btnSave.setOnClickListener{

            var nombre = v.findViewById<EditText>(R.id.editNombre).text.toString()
            var precionormal : Int = 0
            var categoria = v.findViewById<EditText>(R.id.editCategoria).text.toString()
            var stock = v.findViewById<EditText>(R.id.editStock).toString()

            customSQL.insertar(nombre,stock,precionormal,categoria)
        }
        return v
    }
}


