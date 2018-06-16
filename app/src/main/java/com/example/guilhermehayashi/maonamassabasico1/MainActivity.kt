package com.example.guilhermehayashi.maonamassabasico1

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.guilhermehayashi.maonamassabasico1.modelos.Comida
import com.example.guilhermehayashi.maonamassabasico1.modelos.Pessoa
import com.example.guilhermehayashi.maonamassabasico1.network.PokedexService
import com.example.guilhermehayashi.maonamassabasico1.network.PokemonRequest
import com.example.guilhermehayashi.maonamassabasico1.network.RetrofitHelper
import kotlinx.android.synthetic.main.activity_main.*
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class MainActivity : AppCompatActivity() {


    /*
    *
    * MutableList<T> representa uma lista de elementos do tipo T.
    *
    * Dinamica:
    *   - O primeiro usuario come a comida 1 e 2, mas não come a comida 3.
    *   - O segundo usuário come a comida 1 e 3, mas não come a comida 2.
    *   - O terceiro usuário come apenas a comida 3.
    *
    * */

    var comida1: Comida = Comida(nome="Maçã")
    var comida2: Comida = Comida(nome="Banana")
    var comida3: Comida = Comida(nome="Pão")

    var pessoa1: Pessoa = Pessoa(nome="Guilherme")
    var pessoa2: Pessoa = Pessoa(nome="Lucas")
    var pessoa3: Pessoa = Pessoa(nome="Maria")

    var nome: String = ""
    var nomes: MutableList<Pessoa> = mutableListOf(pessoa1, pessoa2, pessoa3)
    var comidas: MutableList<Comida> = mutableListOf()


    object companion {
        val nameKey: String = "NOME_DO_USUARIO"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_layout)
        var retrofit = RetrofitHelper.getRetrofit(false)
        retrofit?.create(PokedexService::class.java)
                ?.getPokemon(1)
                ?.subscribeOn(Schedulers.io())
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribe({
                    Log.d("Pokemon","Pokemon: ${it.name}")
                }, {
                    Log.d("TAG", "Erro: ${it}")
                })

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 100) {
            data?.let {
                nomes = it.getParcelableArrayListExtra(MainActivity.companion.nameKey)
                textoClicou.text = "${nome} a comida:" + comidas
            }
        }
    }

    /*
    *
    * Escopos e variáveis em escopo que é resetado.
    * Regra de negócio
    *
    * */

    fun comeuAlgo(comida: Comida) {
        var texto = ""
        for (pessoa in nomes) {
            pessoa.comerComida(comida)
            texto = texto + pessoa.toString()
        }
        textoClicou.text = texto
    }

}
