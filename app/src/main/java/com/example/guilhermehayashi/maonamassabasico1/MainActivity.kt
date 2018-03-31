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



        pessoas.add("Paiva")//maça
        pessoas.add("Livia")//banana
        pessoas.add("Rodolfo")//pao

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
    * Condicional de comparação
    *
    * if (expressão) {
    *   // código
    * } else {
    *   // código
    * }
    *
    * */

    fun comeuAlgo(comida: String) {
        contador = contador + 1
        comidas = comidas + comida + ","
        if (contador > 3) {
            comidas = "" + comida
        }
        //var nomes = ""
        //for (pessoa in pessoas) {
        // nomes = nomes + pessoa + ", "
        var comeu = ""
        if (comida == "Maçã"){
            comeu=pessoas.get(0)
        } else if (comida == "Banana"){
            comeu=pessoas.get(1)
        } else{
            comeu=pessoas.get(2)
        }

            textoClicou.text = "$comeu comeram a comida:" + comidas

    }
}
