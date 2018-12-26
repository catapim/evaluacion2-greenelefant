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

class CustomSQL (var nombreProducto : String, var cantidad : Int, var categoria : String) {
}