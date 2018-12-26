package com.example.lanavia.evaluacion2_elefanteverde

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.Environment
import android.widget.Toast
import java.io.File
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

    fun insertar (nombreItem : String, cantidadStock : Int, categoriaNombre : String) {
        try {
            val db = this.writableDatabase
            var cv = ContentValues()
            cv.put("nombreItem", nombreItem)
            cv.put("cantidadStock", cantidadStock)
            cv.put("categoriaNombre", categoriaNombre)
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

}