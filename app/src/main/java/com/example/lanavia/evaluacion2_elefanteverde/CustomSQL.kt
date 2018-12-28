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
        var query = "CREATE TABLE ProductosSuper(id INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT, cantidad TEXT, categoria TEXT, precio INTEGER, precioUSD DOUBLE)"
        db?.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }

    fun insertar (nombre: String, cantidad:String, categoria: String, precio: Int, precioUSD: Double?) {
        try {
            val db = this.writableDatabase
            var cv = ContentValues()
            cv.put("nombre", nombre)
            cv.put("cantidad", cantidad)
            cv.put("categoria", categoria)
            cv.put("precio", precio)
            cv.put("precioUSD", precioUSD)
            val resultado = db.insert("ProductosSuper", null, cv)
            db.close()
            if (resultado == -1L) {
                Toast.makeText(miContexto, "Productos no agregados", Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(miContexto, "Productos agregados", Toast.LENGTH_SHORT).show()
            }
        } catch (e: SQLException)
        {
            Toast.makeText(miContexto, "Error al insertar. Revise log.", Toast.LENGTH_LONG).show()
        }
    }

    fun getProductos (): ArrayList<Producto> {
        val db = this.writableDatabase
        var arrayProductos = ArrayList<Producto>()
        val query = "SELECT * FROM ProductosSuper"
        val cursor = db.rawQuery(query, null)
        if (cursor.moveToFirst()) {
            do {
                var id = cursor.getInt(0)
                var nombre= cursor.getString(1)
                var cantidad = cursor.getInt(2)
                var categoria = cursor.getString(3)
                var precio = cursor.getInt(4)
                var precioUSD = cursor.getDouble(5)
                arrayProductos.add(Producto(id,nombre,cantidad,categoria,precio,precioUSD))
            } while (cursor.moveToNext())
        }
        return arrayProductos
    }

}