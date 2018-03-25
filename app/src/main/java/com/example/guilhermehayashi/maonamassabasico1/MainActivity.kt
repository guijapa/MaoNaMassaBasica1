package com.example.guilhermehayashi.maonamassabasico1

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    /*
    *
    * Qualquer variável dentro desse escopo é acessível em qualquer lugar do código. Ver Segunda Activity.
    *
    * object compaion {
    *   var nomeDaVariavel: Tipo = valor
    * }
    *
    * */

    var comidas: String = ""
    var contador: Int = 0
    var nome: String = "Guilherme"
    object companion {
        val nameKey: String = "NOME_DO_USUARIO"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        botaoMaca.setOnClickListener({
            comeuAlgo(comida="Maçã")
        })

        botaoBanana.setOnClickListener({
            comeuAlgo(comida="Banana")
        })
        botaoPao.setOnClickListener({
            comeuAlgo(comida="Pão")
        })
        botaoMudarNome.setOnClickListener({
            /*
            *
            * É dessa forma que iniciamos uma nova Activity.
            *
            * */
            var intent = Intent(this, SegundaActivity::class.java)
            intent.putExtra(MainActivity.companion.nameKey, nome)
            startActivity(intent)
        })

    }

    /*
    *
    * */

    fun comeuAlgo(comida: String) {
        contador = contador + 1
        comidas = comidas + comida + ","
        if (contador > 3) {
            comidas = "" + comida
        }
        textoClicou.text = "Comeu a comida:" + comidas
    }

}
