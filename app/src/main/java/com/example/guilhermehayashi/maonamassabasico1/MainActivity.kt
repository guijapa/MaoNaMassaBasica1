package com.example.guilhermehayashi.maonamassabasico1

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    var contador: Int = 0
    var pessoas: MutableList<Pessoa> = mutableListOf()
    var comidas: MutableList<Comida> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        pessoas.add(Pessoa(nome = "Guilherme"))
        pessoas.add(Pessoa(nome = "Paiva"))
        pessoas.add(Pessoa(nome = "Robson"))

        comidas.add(Comida(nome = "Maçã"))
        comidas.add(Comida(nome = "Banana"))
        comidas.add(Comida(nome = "Pão"))


        botaoMaca.setOnClickListener({
            comeuAlgo(comidas.get(0))
        })

        botaoBanana.setOnClickListener({
            comeuAlgo(comidas.get(1))
        })
        botaoPao.setOnClickListener({
            //comeuAlgo(comidas.get(2))
            var intent = Intent(this, SegundaActivity::class.java)
            startActivity(intent)
        })

    }



    fun comeuAlgo(comida: Comida) {

        contador = contador + 1
        var comidaString: String = ""
        comidaString = comidaString + comida + ","
        if (contador > 3) {
            comidaString = "" + comida
        }
        var comeu = ""
        if (comida == comidas.get(0)){
            comeu=pessoas.get(0).toString()
        } else if (comida == comidas.get(1)){
            comeu=pessoas.get(1).toString()
        } else{
            comeu=pessoas.get(2).toString()
        }

            textoClicou.text = "$comeu comeu a comida: ${comida.nome}"

    }
}