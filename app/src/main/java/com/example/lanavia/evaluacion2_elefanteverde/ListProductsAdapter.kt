package com.example.lanavia.evaluacion2_elefanteverde

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_list_product_stock.view.*

class ListProductsAdapter:RecyclerView.Adapter<CustomViewHolder> (){

    //DataSource
    val rowsOfLayoutProducts = listOf<Product>(Product(1, "Coca-Cola",3, 2000,"bebida"),
        Product(2, "Pinot Noir", 21,7000,"licores" ),
        Product(3, "Johnny walker", 15,21000,"licores"),
        Product(4, "Lomo Argentino", 28,6500,"carnes"),
        Product(5,"Leche Descremada", 4,900,"lacteos"))



    override fun onCreateViewHolder(parentGroup: ViewGroup, viewType: Int): CustomViewHolder {
        //cuando creamos la vista
        //inflamos el elemento
        val layoutInflater = LayoutInflater.from(parentGroup.context)
        val elementOfList= layoutInflater.inflate(R.layout.fragment_list_product_stock,parentGroup,false)

        return CustomViewHolder(elementOfList)
    }

    override fun getItemCount(): Int {
        return rowsOfLayoutProducts.size
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val row = rowsOfLayoutProducts.get(position)
        holder?.itemView?.lblNameProduct?.text =  row.name
        holder?.itemView?.lblStock?.text =  row.stock.toString()

    }


}

class CustomViewHolder(v:View): RecyclerView.ViewHolder(v){
    init {

    }

}


/*
nternal inner class RageComicAdapter(context: Context) : RecyclerView.Adapter<ViewHolder>() {

    private val layoutInflater: LayoutInflater

    init {
      layoutInflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
      val recyclerItemRageComicBinding = RecyclerItemRageComicBinding.inflate(layoutInflater,
          viewGroup, false)
      return ViewHolder(recyclerItemRageComicBinding.root, recyclerItemRageComicBinding)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
      val comic = Comic(imageResIds[position], names[position],
          descriptions[position], urls[position])
      viewHolder.setData(comic)
      viewHolder.itemView.setOnClickListener { listener.onRageComicSelected(comic) }
    }

    override fun getItemCount(): Int {
      return names.size
    }
  }
 */