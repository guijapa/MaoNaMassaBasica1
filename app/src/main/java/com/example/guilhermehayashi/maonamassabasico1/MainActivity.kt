package com.example.guilhermehayashi.maonamassabasico1

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    /*
    *
    * LifeCycle da Activity: onPause, onResume, onCreate
    *
    * */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*
        *   Listeners são métodos que são executados quando existe interação do usuário
        *   com o celular como por ex: Clicar, Scroll, Click longo, ação de marcar como checked (toggle).
        *
        *   Exemplo: idDaViewNoXml.setOnClickListener({
        *   })
        *
        *   Também existe outra definição para listeners, mas por enquanto ele é um ouvinte de eventos.
        *
        * */

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

    /*
    * Tipos Primitivos:
    *
    * String | Texto ("", "exemplo1", "qualquer texto \n com quebra de linha")
    * Int    | Inteiro (0, 1, 2, 3, 5, -10, 9)
    * Double | Decimal (0.1, 0.2, 0.5, -10.5. 10, 4)
    *
    * Método comeuAlgo é invocado passando uma String para ser usado no bloco de código do método.
    *
    *
    * */

    fun comeuAlgo(comida: String) {
        textoClicou.text = "Comeu a comida:" + comida
    }

}
