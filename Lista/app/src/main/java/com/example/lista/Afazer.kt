package com.example.lista

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Afazer(val titulo: String, val descricao: String) {

    @PrimaryKey(autoGenerate = true)
    var id : Long = 0

}