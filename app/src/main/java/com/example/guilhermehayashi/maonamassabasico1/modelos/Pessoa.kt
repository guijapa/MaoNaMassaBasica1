package com.example.guilhermehayashi.maonamassabasico1.modelos

import android.os.Parcel
import android.os.Parcelable

class Pessoa(var nome: String, var comidas: MutableList<Comida> = mutableListOf()): Parcelable {

    companion object CREATOR: Parcelable.Creator<Pessoa> {
        override fun createFromParcel(source: Parcel?): Pessoa {
            return Pessoa(source)
        }

        override fun newArray(size: Int): Array<Pessoa> {
            return newArray(size)
        }
    }

    constructor(parcel: Parcel?): this(parcel?.readString() ?: "")

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.writeString(nome)
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun toString(): String {
        return "Meu nome é: ${nome} e eu comi: ${comidas.count()} comidas. \n"
    }

    fun comerComida(comida: Comida) {
        this.comidas.add(comida)
    }
}