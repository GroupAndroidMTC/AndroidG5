package com.example.recorridocafetero.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.recorridocafetero.databinding.FragmentDetailBinding


class DetailFragment : Fragment() {
    private lateinit var detailBinding: FragmentDetailBinding
    private val args: DetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        detailBinding = FragmentDetailBinding.inflate(inflater, container, false)
        return detailBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val lugar = args.lugar
        with(detailBinding){
            nombreTextView.text = lugar.nombre
            detalleTextView.text = lugar.detalle
            direccionTextView.text = lugar.ubicacion
            horaTextView.text = lugar.horario
            numeroTextView.text = lugar.telefono
            webTextView.text = lugar.paginaWeb
            com.squareup.picasso.Picasso.get().load(lugar.urlDetalle).into(photoImageView)


        }
    }


}