package com.example.listadodelugares.model


import com.google.gson.annotations.SerializedName

data class LugarItem(
    @SerializedName("calificacion")
    val calificacion: Double,
    @SerializedName("description")
    val description: String,
    @SerializedName("nombre")
    val nombre: String,
    @SerializedName("urlPicture")
    val urlPicture: String
)