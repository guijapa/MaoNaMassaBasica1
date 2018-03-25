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
        botaoVermelho.setOnClickListener({
            click()
        })
    }

    /*
    *
    * Um método possui o seguinte formato
    *
    * fun nomeDoMetodo(parametros: tipo ou simplesmente vazio) {
    *   // instruções de código que podem ser invocados a qualquer instante dentro dessa Activity
    * }
    *
    * */

    fun click() {
        textoClicou.text = "O botão foi clicado"
    }

}
