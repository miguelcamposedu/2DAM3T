package com.miguelcampos.a03_fragmentolista

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import com.miguelcampos.a03_fragmentolista.placeholder.PlaceholderContent.PlaceholderItem
import com.miguelcampos.a03_fragmentolista.databinding.FragmentPokemonBinding

class MyPokemonRecyclerViewAdapter(
    private val values: List<PlaceholderItem>
) : RecyclerView.Adapter<MyPokemonRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            FragmentPokemonBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pokemonActual = values[position]
        holder.idView.text = pokemonActual.id
        holder.contentView.text = pokemonActual.content
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: FragmentPokemonBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val idView: TextView = binding.itemNumber
        val contentView: TextView = binding.content
        val imagenPokemon: ImageView = binding.imageViewPokemon
    }

}