package com.example.guilhermehayashi.maonamassabasico1

import android.os.Parcel
import android.os.Parcelable

class Pessoa (var nome: String){
    override fun toString(): String {
        return nome
    }
}

class Comida (var nome: String){
    override fun toString(): String {
        return nome
    }
}