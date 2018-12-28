package com.example.lanavia.evaluacion2_elefanteverde

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_frag_registro.*


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class Fragmento_Registro (var valorDolar: Double) : Fragment() {

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
           try {
               var precioIVA = Math.rint((precionormal.toInt() * 1.19))
               var precioUSD = Math.rint((precionormal.toInt() / valorDolar))

               if (nombre.length == 0 || cantidad.length == 0 || categoria.length == 0 || precionormal.length == 0) {

                   Toast.makeText(miContexto, "Debes llenar todos los campos para registrar un producto /o/", Toast.LENGTH_LONG).show()
               } else {
                   customSQL.insertar(nombre, cantidad, categoria, precionormal.toInt(), precioIVA, precioUSD)
               }
           } catch (e: Exception) {
               Toast.makeText(miContexto, "No dejes campos en blanco >.<", Toast.LENGTH_LONG).show()
               e.printStackTrace();
           }

            editNombre.text.clear()
            editCantidad.text.clear()
            editCategoria.text.clear()
            editPrecioNormal.text.clear()
        }
        return v
    }
}


