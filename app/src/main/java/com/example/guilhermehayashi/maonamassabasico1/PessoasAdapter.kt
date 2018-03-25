package com.example.guilhermehayashi.maonamassabasico1

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.guilhermehayashi.maonamassabasico1.modelos.Comida
import com.example.guilhermehayashi.maonamassabasico1.modelos.Pessoa

class PessoasAdapter(var pessoas: MutableList<Pessoa>, var context: Context): RecyclerView.Adapter<PessoasAdapter.PessoaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PessoaViewHolder {
        return PessoaViewHolder(LayoutInflater.from(context).inflate(R.layout.pessoa_layout_view_holder, parent, false))
    }

    override fun getItemCount(): Int {
        return pessoas.count()
    }

    override fun onBindViewHolder(holder: PessoaViewHolder, position: Int) {
        holder.configurar(pessoas[position])
    }

    class PessoaViewHolder(var view: View): RecyclerView.ViewHolder(view) {

        var pessoa: Pessoa? = null
        var nomeTextView: TextView? = null
        var nomeEditView: EditText? = null
        var okButton: Button? = null

        init {
            this.nomeTextView = view.findViewById(R.id.nomePessoaText)
            this.nomeEditView = view.findViewById(R.id.nomePessoaEdit)
            this.okButton = view.findViewById(R.id.pessoaOkButton)
            this.okButton?.setOnClickListener({
                this.pessoa?.favoritas?.add(Comida(nome=nomeEditView?.text.toString()))
            })
        }

        fun configurar(pessoa: Pessoa) {
            this.pessoa = pessoa
            this.nomeTextView?.text = pessoa.nome
        }
    }

}