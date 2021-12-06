package com.example.recorridocafetero.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recorridocafetero.databinding.FragmentListBinding
import com.example.recorridocafetero.model.Lugar
import com.example.recorridocafetero.model.LugarItem
import com.google.gson.Gson



class ListFragment : Fragment() {
    private lateinit var listBinding: FragmentListBinding
    private lateinit var lugaresAdapter: LugaresAdapter
    private  lateinit var listLugares: ArrayList<LugarItem>



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        listBinding= FragmentListBinding.inflate(inflater, container, false)

        return listBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listLugares = loadMockLugaresFromJson()
        lugaresAdapter = LugaresAdapter(listLugares, onItemClicked = { onLugarClicked (it) })
        listBinding.lugaresRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = lugaresAdapter
            setHasFixedSize(false)
        }
    }

    private fun onLugarClicked(lugar: LugarItem) {
        findNavController().navigate(ListFragmentDirections.actionListFragmentToDetailFragment2(lugar= lugar))
    }


    private fun loadMockLugaresFromJson(): ArrayList<LugarItem> {
        val lugarString = context?.assets?.open("lugares.json")?.bufferedReader().use{it?.readText()}
        val gson = Gson()
        val lugarList = gson.fromJson(lugarString, Lugar :: class.java)
        return lugarList

    }


}