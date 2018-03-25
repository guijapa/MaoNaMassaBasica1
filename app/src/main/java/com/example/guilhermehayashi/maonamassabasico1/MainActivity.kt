package com.example.guilhermehayashi.maonamassabasico1

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.guilhermehayashi.maonamassabasico1.modelos.Comida
import com.example.guilhermehayashi.maonamassabasico1.modelos.Pessoa
import kotlinx.android.synthetic.main.activity_main.*

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
        setContentView(R.layout.activity_main)
        comidas.add(comida1)
        comidas.add(comida2)
        comidas.add(comida3)

        botaoMaca.setOnClickListener({
            comeuAlgo(comida=comida1)
        })

        botaoBanana.setOnClickListener({
            comeuAlgo(comida=comida2)
        })
        botaoPao.setOnClickListener({
            comeuAlgo(comida=comida3)
        })
        botaoMudarNome.setOnClickListener({
            var intent = Intent(this, SegundaActivity::class.java)
            intent.putParcelableArrayListExtra(MainActivity.companion.nameKey, nomes as ArrayList<Pessoa>)
            startActivityForResult(intent, 100)
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
