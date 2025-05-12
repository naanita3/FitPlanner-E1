package com.equno.fitplanner

import android.os.Parcel
import android.os.Parcelable

data class Ejercicio(
    val id: String = "",
    val nombre: String = "",
    val tipo: String = "",
    val imagenUrl: String = "" // Nueva propiedad para la imagen
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

    companion object CREATOR : Parcelable.Creator<Ejercicio> {
        override fun createFromParcel(parcel: Parcel): Ejercicio {
            return Ejercicio(parcel)
        }

        override fun newArray(size: Int): Array<Ejercicio?> {
            return arrayOfNulls(size)
        }
    }
}

