package com.example.lanavia.evaluacion2_elefanteverde

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var customSQL = CustomSQL(this, "ProductosSuper", null,1)

        btnListProduct.setOnClickListener {
            val fm = supportFragmentManager
            val ft = fm.beginTransaction()
                //  val listProductsFragment = ListProductsFragment()
          //  listProductsFragment.miContexto = this
             //       ft.replace(R.id.lyFrag,ListProductsFragment())
            ft.commit()
        }

        btnAddProduct.setOnClickListener{
            val fm = supportFragmentManager
            val ft = fm.beginTransaction()
            val registroFragmento = frag_registro()
            registroFragmento.miContexto = this
            ft.replace(R.id.lyFrag,frag_registro())
            ft.commit()
        }


    }
}
