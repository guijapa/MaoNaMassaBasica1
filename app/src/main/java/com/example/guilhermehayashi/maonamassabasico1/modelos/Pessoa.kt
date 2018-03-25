package com.example.guilhermehayashi.maonamassabasico1.modelos

import android.os.Parcel
import android.os.Parcelable

/*
*
* class NomeDaClasse {
*   var atributos: Tipo = valor
* }
*
* Definimos a classe Pessoa que vai ter um atributo nome.
*
* Sobrescrevemos o método toString() que representa o objeto quando ele é printado.
*
* */

class Pessoa(var nome: String): Parcelable {

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
        return nome
    }
}