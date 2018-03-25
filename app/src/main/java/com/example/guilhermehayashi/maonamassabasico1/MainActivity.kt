package com.example.guilhermehayashi.maonamassabasico1

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
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

    var comidas: String = ""
    var contador: Int = 0
    var nome: String = "Guilherme"

    var pessoa1: Pessoa = Pessoa(nome="Guilherme")
    var pessoa2: Pessoa = Pessoa(nome="Lucas")
    var pessoa3: Pessoa = Pessoa(nome="Maria")

    var nomes: MutableList<Pessoa> = mutableListOf<Pessoa>(pessoa1, pessoa2, pessoa3)


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
            startActivityForResult(intent, 100)
        })

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 100) {
            data?.let {
                nome = it.getStringExtra(MainActivity.companion.nameKey)
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

    fun comeuAlgo(comida: String) {
        var textoUsuario1: String = ""
        var textoUsuario2: String = ""
        var textoUsuario3: String = ""
        if (comida == "Maçã") {
            textoUsuario1 = "${nomes[0]} comeu"
            textoUsuario2 = "${nomes[1]} comeu"
        }
        if (comida == "Banana") {
            textoUsuario1 = "${nomes[0]} comeu"
        }
        if (comida == "Pão") {
            textoUsuario1 = "${nomes[1]} comeu"
            textoUsuario2 = "${nomes[2]} comeu"
        }
        textoClicou.text = "${textoUsuario1}\n ${textoUsuario2}\n ${textoUsuario3}"
    }

}
