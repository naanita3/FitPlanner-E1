package com.equno.fitplanner

import android.os.Parcel
import android.os.Parcelable

data class Alimento(
    val id: String = "",
    val nombre: String = "",
    val tipo: String = ""
) : Parcelable {

    // Constructor para Parcelable
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: ""
    )

    // Constructor para Parcelable
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(nombre)
        parcel.writeString(tipo)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Alimento> {
        override fun createFromParcel(parcel: Parcel): Alimento {
            return Alimento(parcel)
        }

        override fun newArray(size: Int): Array<Alimento?> {
            return arrayOfNulls(size)
        }
    }
}
