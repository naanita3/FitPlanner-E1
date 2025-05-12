package com.equno.fitplanner

import android.os.Parcel
import android.os.Parcelable

data class Alimento(
    val id: String = "",
    val nombre: String = "",
    val tipo: String = "",
    val imagenUrl: String = "" // Asegúrate que esta propiedad existe
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "" // No olvides leer la URL
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(nombre)
        parcel.writeString(tipo)
        parcel.writeString(imagenUrl) // No olvides escribir la URL
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<Alimento> {
        override fun createFromParcel(parcel: Parcel): Alimento {
            return Alimento(parcel)
        }

        override fun newArray(size: Int): Array<Alimento?> {
            return arrayOfNulls(size)
        }
    }
}