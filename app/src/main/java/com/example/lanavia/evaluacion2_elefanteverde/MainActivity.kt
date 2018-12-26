package com.example.lanavia.evaluacion2_elefanteverde

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnListProduct.setOnClickListener {

              /*  val fm = supportFragmentManager
                val ft = fm.beginTransaction()
                val allProductsFragment = AllProductsFragment()
                allProductsFragment.miContext=this
                //acá indico el fragmento donde pondré la lista de productos
                ft.replace(R.id.lyFrag,allProductsFragment)
                ft.commit()*/

            val fm = supportFragmentManager
            val ft = fm.beginTransaction()
            val listProductsFragment = ListProductsFragment()
            listProductsFragment.myContext = this

            //acá indico el fragmento donde pondré la lista de productos
            ft.replace(R.id.lyFrag,listProductsFragment)
            ft.commit()
        }
    }
}
