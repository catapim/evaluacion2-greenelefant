package com.example.lanavia.evaluacion2_elefanteverde

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var customSQL = CustomSQL(this, "ProductosSuper", null,1)

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
            val registroFragmento = Fragmento_Registro()
            registroFragmento.miContexto = this
            ft.replace(R.id.lyFragReplace,Fragmento_Registro())
            ft.commit()
        }
    }
}
