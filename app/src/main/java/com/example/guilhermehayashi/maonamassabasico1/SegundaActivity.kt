package com.example.guilhermehayashi.maonamassabasico1

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.example.guilhermehayashi.maonamassabasico1.modelos.Pessoa

import kotlinx.android.synthetic.main.activity_segunda.*
import java.util.ArrayList

class SegundaActivity : AppCompatActivity() {

    var nome: String = ""
    var pessoas: MutableList<Pessoa> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segunda)
        pessoas = intent.getParcelableArrayListExtra<Pessoa>(MainActivity.companion.nameKey) as MutableList<Pessoa>
        botaoOk.setOnClickListener({
            /*
            *
            * Passando dados entre activities
            *
            * */
            var intent = Intent()
            intent.putParcelableArrayListExtra(MainActivity.companion.nameKey, pessoas as ArrayList<Pessoa>)
            setResult(Activity.RESULT_OK, intent)
            finish()
        })
        listaPessoas.layoutManager = LinearLayoutManager(this)
        listaPessoas.adapter = PessoasAdapter(pessoas, this)
        listaPessoas.adapter.notifyDataSetChanged()
    }

}
