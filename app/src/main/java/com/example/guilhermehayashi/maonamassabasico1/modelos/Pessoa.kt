package com.example.guilhermehayashi.maonamassabasico1.modelos

import android.os.Parcel
import android.os.Parcelable


class Pessoa(var nome: String): Parcelable
{
    override fun toString(): String {
        return nome
    }

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.writeString(nome)
    }

    override fun describeContents(): Int {
        return 0
    }
}

