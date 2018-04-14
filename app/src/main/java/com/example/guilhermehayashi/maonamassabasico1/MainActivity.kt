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

    var contador: Int = 0
    var pessoas: MutableList<Pessoa> = mutableListOf()
    var comidas: MutableList<Comida> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pessoas.add(Pessoa(nome = "João"))
        pessoas.add(Pessoa(nome = "Lucas"))
        pessoas.add(Pessoa(nome = "Robinson"))

        comidas.add(Comida(nome = "Maça"))
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
            var intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        })


    }



    fun comeuAlgo(comida: Comida) {
        contador = contador + 1
        var comidas_list: String = ""
        comidas_list = comidas_list + comida + ","
        if (contador > 3) {
            comidas_list = "" + comida
        }

        var comeu = ""
        if (comida == comidas.get(0)){
            comeu=pessoas.get(0).toString()
        }
        else if(comida ==comidas.get(1)){
            comeu=pessoas.get(1).toString()
        }
        else {
            comeu = pessoas.get(2).toString()
        }
            textoClicou.text = "$comeu comeu a comida: ${comida.nome}"
    }

}

