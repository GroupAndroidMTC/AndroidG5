package com.example.listadodelugares

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

class ListLugaresActivity : AppCompatActivity() {

    private lateinit var listLugares: ArrayList<Lugar>
    private lateinit var lugaresAdapter: LugaresAdapter
    private lateinit var lugaresRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_lugares)

        lugaresRecyclerView = findViewById(R.id.lugares_recycler_view)
        listLugares = createMockLugares()
        lugaresAdapter = LugaresAdapter(listLugares)

        lugaresRecyclerView.apply { layoutManager = LinearLayoutManager(context)
            adapter = lugaresAdapter
            setHasFixedSize(false)
        }
    }

    private fun createMockLugares(): ArrayList<Lugar> {
        return arrayListOf(
            Lugar(
                nombre = "Panaca",
                description = "Parque temático agropecuario",
                calificacion = 4.5,
                urlPicture = "https://i.imgur.com/wlvq2tz.jpg",
            ),
            Lugar(
                nombre = "Cocora",
                description = "Maravilloso paisaje natural",
                calificacion = 4.9,
                urlPicture = "https://i.imgur.com/CcabiWl.jpg",
            ),
            Lugar(
                nombre = "Parque del  café",
                description = "Parque temático del café",
                calificacion = 5.0,
                urlPicture = "https://i.imgur.com/Sc6SyRE.jpg",
            ),
            Lugar(
                nombre = "Salento",
                description = "Ciudad andina de colombia",
                calificacion = 4.5,
                urlPicture = "https://i.imgur.com/LUw2rII.jpg",
            ),
            Lugar(
                nombre = "Recuca",
                description = "Recorrido a la cultura cafetera",
                calificacion = 4.0,
                urlPicture = "https://i.imgur.com/kXwi5lL.jpg",
            )
        )
    }
}