package com.example.listadodelugares.list

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import com.example.listadodelugares.R
import com.example.listadodelugares.model.LugarItem
import com.squareup.picasso.Picasso

class LugaresAdapter(private val lugaresList: ArrayList<LugarItem>)
    : RecyclerView.Adapter<LugaresAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent:  ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_view_lugar_item, parent, false)
        return  ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val lugar = lugaresList[position]
        holder.bind(lugar)

    }

    override fun getItemCount(): Int = lugaresList.size


    class ViewHolder(view: View): RecyclerView.ViewHolder(view){

        private var nameTextView: TextView = itemView.findViewById(R.id.name_text_view)
        private var descriptionTextView : TextView = itemView.findViewById(R.id.description_text_view)
        private var ratingBar: RatingBar = itemView.findViewById(R.id.score_double_view)
        private var pictureImageView: ImageView = itemView.findViewById((R.id.picture_image_view))

        fun bind(lugar: LugarItem){
            nameTextView.text = lugar.nombre
            descriptionTextView.text = lugar.description
            ratingBar.rating = lugar.calificacion.toFloat()
            Picasso.get().load(lugar.urlPicture).into(pictureImageView)

        }

    }
}