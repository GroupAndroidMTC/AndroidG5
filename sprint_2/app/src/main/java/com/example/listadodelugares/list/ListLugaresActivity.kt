package com.example.listadodelugares.list

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.listadodelugares.R
import com.example.listadodelugares.model.Lugar
import com.example.listadodelugares.model.LugarItem
import com.google.gson.Gson

class ListLugaresActivity : AppCompatActivity() {

    private lateinit var listLugares: ArrayList<LugarItem>
    private lateinit var lugaresAdapter: LugaresAdapter
    private lateinit var lugaresRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_lugares)

        lugaresRecyclerView = findViewById(R.id.lugares_recycler_view)
        listLugares = loadMockLugaresFromJson()
        lugaresAdapter = LugaresAdapter(listLugares)

        lugaresRecyclerView.apply { layoutManager = LinearLayoutManager(context)
            adapter = lugaresAdapter
            setHasFixedSize(false)
        }
    }

    private fun loadMockLugaresFromJson(): ArrayList<LugarItem> {
        val lugarString: String = applicationContext.assets.open("lugares.json").bufferedReader().use{it.readText()}
        val gson = Gson()
        val data = gson.fromJson(lugarString, Lugar :: class.java)
        return data

    }


}