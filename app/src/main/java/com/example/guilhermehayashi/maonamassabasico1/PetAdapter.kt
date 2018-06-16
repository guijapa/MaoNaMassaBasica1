package com.example.guilhermehayashi.maonamassabasico1

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.guilhermehayashi.maonamassabasico1.network.Pet

class PetAdapter(var pets: MutableList<Pet>, var context: Context): RecyclerView.Adapter<PetAdapter.PetViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PetViewHolder {
        return PetViewHolder(LayoutInflater.from(context).inflate(R.layout.pet_view_holder, parent, false))
    }

    override fun getItemCount(): Int {
        return pets.count()
    }

    override fun onBindViewHolder(holder: PetViewHolder, position: Int) {
        holder.configurar(pets[position])
    }

    class PetViewHolder(var view: View): RecyclerView.ViewHolder(view) {

        var nomeTextView: TextView? = null
        var descricaoTextView: TextView? = null

        init {
            nomeTextView = view.findViewById(R.id.nomeTextView)
            descricaoTextView = view.findViewById(R.id.descricaoTextView)
        }

        fun configurar(pet: Pet) {
            nomeTextView?.text = pet.nome
            descricaoTextView?.text = pet.descricao
        }

    }

}