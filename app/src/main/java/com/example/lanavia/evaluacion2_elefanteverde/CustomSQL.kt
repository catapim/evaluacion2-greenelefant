package com.example.lanavia.evaluacion2_elefanteverde

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast
import java.sql.SQLException

class CustomSQL (val miContexto: Context,
                 var nombreDb : String,
                 val factory: SQLiteDatabase.CursorFactory?,
                 var version : Int) : SQLiteOpenHelper(miContexto, nombreDb,factory,version) {

    override fun onCreate(db: SQLiteDatabase?) {
        var query = "CREATE TABLE ProductosSuper(id INTEGER PRIMARY KEY AUTOINCREMENT, Nombre TEXT, Cantidad TEXT, Categoria TEXT)"
        db?.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }

    fun insertar (name: String, stock: String, normalPrice: Int?, category: String) {
        try {
            val db = this.writableDatabase
            var cv = ContentValues()
            cv.put("name", name)
            cv.put("stock", stock)
            cv.put("normalPrice", normalPrice)
            cv.put("category", category)
            val resultado = db.insert("ProductosSuper", null, cv)
            db.close()
            if (resultado == 1L) {
                System.out.println("mensaje no agregado")
                Toast.makeText(miContexto, "Productos no agregados", Toast.LENGTH_SHORT).show()
            }
            else {
                System.out.println("mensaje agregado")
                Toast.makeText(miContexto, "Productos agregados", Toast.LENGTH_SHORT).show()

            }
        } catch (e: SQLException)
        {
            System.out.println("Error al insertar producto en la DB")
            Toast.makeText(miContexto, "Error al insertar. Revise log.", Toast.LENGTH_LONG).show()
        }
    }

    fun getProductos (): ArrayList<Product> {
        val db = this.writableDatabase
        var arrayProductos = ArrayList<Product>()
        val query = "SELECT * FROM ProductosSuper"
        val cursor = db.rawQuery(query, null)
        if (cursor.moveToFirst()) {
            do {
                var id = cursor.getInt(0)
                var name= cursor.getString(1)
                var stock = cursor.getInt(2)
                var normalPrice = cursor.getInt(3)
                var category = cursor.getString(4)
                arrayProductos.add(Product(id,name,stock,normalPrice,category))
            } while (cursor.moveToNext())
        }
        return arrayProductos
    }

}