package com.example.guilhermehayashi.maonamassabasico1

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.guilhermehayashi.maonamassabasico1.modelos.Comida
import com.example.guilhermehayashi.maonamassabasico1.modelos.Pessoa
import com.example.guilhermehayashi.maonamassabasico1.network.PokedexService
import com.example.guilhermehayashi.maonamassabasico1.network.Pokemon
import com.example.guilhermehayashi.maonamassabasico1.network.RetrofitHelper
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.main_layout.*
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    object companion {
        val nameKey: String = "NOME_DO_USUARIO"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_layout)
        var retrofit = RetrofitHelper.getRetrofit(false)
        retrofit?.create(PokedexService::class.java)
                ?.getPokemons()
                ?.subscribeOn(Schedulers.io())
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribe({
                    it?.results?.forEach({
                        Log.d("Pokemon","Pokemon: ${it.name}")
                    })
                    it?.let {
                        pokemonList.adapter = PokedexAdapter(it.results.toMutableList(), this)
                    }

                }, {
                    Log.d("TAG", "Erro: ${it}")
                })

    }

}
