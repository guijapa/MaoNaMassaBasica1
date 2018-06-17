package com.example.guilhermehayashi.maonamassabasico1

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.guilhermehayashi.maonamassabasico1.modelos.Comida
import com.example.guilhermehayashi.maonamassabasico1.modelos.Pessoa
import com.example.guilhermehayashi.maonamassabasico1.network.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.main_layout.*
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    object companion {
        val nameKey: String = "NOME_DO_USUARIO"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_layout)


        novoPetButton.setOnClickListener {
            val intent = Intent(this, NovoPetActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onResume() {
        super.onResume()
        Api.list {
            pokemonList.adapter = PetAdapter(it.results.toMutableList(), this)
        }
    }

}
