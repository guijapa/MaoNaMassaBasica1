package com.example.guilhermehayashi.maonamassabasico1

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.guilhermehayashi.maonamassabasico1.network.ApiDetailResponse
import com.google.gson.Gson

class PetAdapter(var pets: MutableList<ApiDetailResponse>, var context: Context): RecyclerView.Adapter<PetAdapter.PetViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PetViewHolder {
        return PetViewHolder(LayoutInflater.from(context).inflate(R.layout.pet_view_holder, parent, false), context)
    }

    override fun getItemCount(): Int {
        return pets.count()
    }

    override fun onBindViewHolder(holder: PetViewHolder, position: Int) {
        holder.configurar(pets[position])
    }

    class PetViewHolder(var view: View, var context: Context): RecyclerView.ViewHolder(view) {

        var nomeTextView: TextView? = null
        var pet: ApiDetailResponse? = null

        init {
            nomeTextView = view.findViewById(R.id.nomeTextView)
            view.setOnClickListener {
                var intent = Intent(context, DetalheActivity::class.java)
                intent.putExtra("PET", Gson().toJson(pet))
                context.startActivity(intent)
            }
        }

        fun configurar(pet: ApiDetailResponse) {
            this.pet = pet
            nomeTextView?.text = pet.nome

        }

    }

}

