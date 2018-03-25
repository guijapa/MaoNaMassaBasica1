package com.example.guilhermehayashi.maonamassabasico1.modelos

import android.os.Parcel
import android.os.Parcelable

class Comida(var nome: String): Parcelable {

    companion object CREATOR: Parcelable.Creator<Comida> {
        override fun createFromParcel(source: Parcel?): Comida {
            return Comida(source)
        }

        override fun newArray(size: Int): Array<Comida> {
            return newArray(size)
        }
    }

    constructor(source: Parcel?): this(source?.readString() ?: "")

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.writeString(nome)
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun equals(other: Any?): Boolean {
        return nome == (other as? Comida)?.nome
    }

}