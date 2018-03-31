package com.example.guilhermehayashi.maonamassabasico1

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    /*
    *
    * Variáveis: são valores que estão guardados para uso posteriores. Por ex.
    *
    * A variável a terá o valor 2 enquanto não for alterada. E x terá o valor 12.
    * a = 2
    * x = a + 10
    * x = 12
    *
    * Formato:
    *
    * var nomeDaVariavel: Tipo = valor
    *
    *
    * */

    var comidas: String = ""
    var contador: Int = 0
    var pessoas: MutableList<String> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pessoas.add("João")//maça
        pessoas.add("Lucas")//banana
        pessoas.add("Robinson")//pao
        pessoas.add("")//nada

        botaoMaca.setOnClickListener({
            comeuAlgo(comida="Maçã")
        })

        botaoBanana.setOnClickListener({
            comeuAlgo(comida="Banana")
        })
        botaoPao.setOnClickListener({
            comeuAlgo(comida="Pão")
        })

    }



    fun comeuAlgo(comida: String) {
        contador = contador + 1
        comidas = comidas + comida + ","
        if (contador > 3) {
            comidas = "" + comida
        }

        var comeu = ""
        if (comida == "Maçã"){
            comeu=pessoas.get(0)
        }
        else if(comida =="Banana"){
            comeu=pessoas.get(1)
        }
        else {
            comeu = pessoas.get(2)
        }
            textoClicou.text = comeu + " comeru a comida:" + comida
    }

}

//var nomes = ""
//for(pessoa in pessoas) {
//    nomes = nomes + pessoa + ","