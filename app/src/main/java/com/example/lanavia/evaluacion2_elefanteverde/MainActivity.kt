package com.example.lanavia.evaluacion2_elefanteverde

import android.content.DialogInterface
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.io.IOException
import com.google.gson.GsonBuilder
import okhttp3.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var customSQL = CustomSQL(this, "ProductosSuper", null,1)
        var valorDolarArray : ArrayList<ValorDolar> = ArrayList()
        var valorDolar : Double? = null

        btnListProduct.setOnClickListener {
            val fm = supportFragmentManager
            val ft = fm.beginTransaction()
            val listProductsFragment = ListProductsFragment()
            listProductsFragment.miContexto = this
            ft.replace(R.id.lyFragReplace,ListProductsFragment())
            ft.commit()
        }

        btnAddProduct.setOnClickListener{
            val fm = supportFragmentManager
            val ft = fm.beginTransaction()
            val registroFragmento = Fragmento_Registro(valorDolar!!)
            registroFragmento.miContexto = this
            ft.replace(R.id.lyFragReplace,Fragmento_Registro(valorDolar!!))
            ft.commit()
        }

        val url = "https://mindicador.cl/api/dolar"
        val request =Request.Builder().url(url).build()
        val cliente = OkHttpClient()

        cliente.newCall(request).enqueue(object :Callback{

            override fun onFailure(call: Call?, e: IOException?) {
                runOnUiThread {
                    var mialerta = AlertDialog.Builder(this@MainActivity)
                    mialerta.setTitle("Error!")
                    mialerta.setMessage("No se pudo obtener el valor del dolar :(")
                    mialerta.setNegativeButton("Ok", DialogInterface.OnClickListener
                    { dialog, which ->  dialog.cancel()})
                    mialerta.show()
                }
            }
            override fun onResponse(call: Call?, response: Response?) {
                val respuesta = response?.body()?.string()
                val gson = GsonBuilder().create()
                val indicador = gson.fromJson(respuesta, Indicador::class.java)
                valorDolarArray = indicador.serie
                valorDolar = valorDolarArray[0].valor

            }
        }
        )

    }
}
