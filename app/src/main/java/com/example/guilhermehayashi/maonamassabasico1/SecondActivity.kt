package com.example.guilhermehayashi.maonamassabasico1

import android.content.Context
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = NossoPrimeiroAdapter(this)
    }

}
class NossoPrimeiroAdapter(var contexto: Context): RecyclerView.Adapter<NossoPrimeiroViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NossoPrimeiroViewHolder {
        return NossoPrimeiroViewHolder(LayoutInflater.from(contexto).inflate(R.layout.nosso_priemeiro_view_holder, parent, false))
    }

    override fun getItemCount(): Int {
        return 3
    }

    override fun onBindViewHolder(holder: NossoPrimeiroViewHolder, position: Int) {

    }
}
class NossoPrimeiroViewHolder(var view: View): RecyclerView.ViewHolder(view){

}
