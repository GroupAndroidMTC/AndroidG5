package com.example.sprint_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.util.Log
import org.json.JSONArray
import java.io.IOException
import java.io.InputStream

class MainActivity : AppCompatActivity() {
    var arr = arrayListOf<String>()
    val lugares = arrayOf("Panaca", "Parque del Café", "Valle del Cocora")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        read_json()

        val lvPlaces = findViewById<ListView>(R.id.lvPlaces)
        val arrayAdapter: ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_list_item_1, arr)
        lvPlaces.adapter = arrayAdapter

        lvPlaces.setOnItemClickListener(AdapterView.OnItemClickListener { parent, view, position, id ->
            Toast.makeText(this, "Sitio seleccionado: "+ lugares[position], Toast.LENGTH_LONG).show()
        })
    }

    fun read_json(){
        var json : String? = null

        try {
            val inputStream:InputStream = assets.open("cityData.json")
            json = inputStream.bufferedReader().use { it.readText() }

            var jsonArr = JSONArray(json)

            for (i in 0..jsonArr.length()-1){
                var jsonObj = jsonArr.getJSONObject(i)
                arr.add(jsonObj.getString("nombre"))
            }
        }
        catch (e: IOException){ }
    }
}