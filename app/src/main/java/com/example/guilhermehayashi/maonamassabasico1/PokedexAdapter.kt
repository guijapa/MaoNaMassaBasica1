package com.example.guilhermehayashi.maonamassabasico1

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.guilhermehayashi.maonamassabasico1.network.Pokemon

class PokedexAdapter(var pokemons: MutableList<Pokemon>, var context: Context): RecyclerView.Adapter<PokedexAdapter.PokemonViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        return PokemonViewHolder(LayoutInflater.from(context).inflate(R.layout.pokemon_view_holder, parent, false))
    }

    override fun getItemCount(): Int {
        return pokemons.count()
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        holder.bind(pokemons[position])
    }

    class PokemonViewHolder(var view: View): RecyclerView.ViewHolder(view) {
        var nameText: TextView? = null

        init {
            this.nameText = view.findViewById(R.id.pokemon_name_text)
        }

        fun bind(pokemon: Pokemon) {
            this.nameText?.text = pokemon.name
        }


    }

}