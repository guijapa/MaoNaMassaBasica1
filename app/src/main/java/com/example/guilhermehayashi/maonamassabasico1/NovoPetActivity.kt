package com.example.guilhermehayashi.maonamassabasico1

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import com.example.guilhermehayashi.maonamassabasico1.network.ApiService
import com.example.guilhermehayashi.maonamassabasico1.network.Pet
import com.example.guilhermehayashi.maonamassabasico1.network.PetSaveRequest
import com.example.guilhermehayashi.maonamassabasico1.network.RetrofitHelper
import kotlinx.android.synthetic.main.novo_pet_activity.*
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers


class NovoPetActivity: AppCompatActivity() {

    val tipos = arrayListOf("cachorro", "gato", "outro")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.novo_pet_activity)
        tipoSpinner.adapter = ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, tipos)
        criarButton.setOnClickListener {
            var nome = nomePetEditText.text.toString()
            var descricao = descricaoEditText.text.toString()
            var tipo = tipos[tipoSpinner.selectedItemPosition]
            var dono = LoginActivity.companion.user?.id
            var pet = PetSaveRequest(dono!!.toString(), nome, tipo, descricao)
            var retrofit = RetrofitHelper.getRetrofit(true)
            retrofit?.create(ApiService::class.java)?.savePets(pet)
                    ?.subscribeOn(Schedulers.io())
                    ?.observeOn(AndroidSchedulers.mainThread())
                    ?.subscribe({
                        finish()
                    }, {
                        finish()
                    })
        }
    }

}