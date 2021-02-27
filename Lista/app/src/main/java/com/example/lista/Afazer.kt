package com.example.lista

data class Afazer(val titulo: String, val descricao: String) {

    companion object {
        fun obterAfazeres(): MutableList<Afazer> {
            val dados = mutableListOf(
                Afazer("Vingadores", "Filme de Super Heroi"),
                Afazer("Fazer o TCC", "Quero o Diploma"),
                Afazer("Visitar as Cataratas", "Cataratas do Iguaçu")
            )

//            for(i in 1..2000) {
//                dados.add(
//                    Afazer("Título $i", "Descrição $i")
//                )
//            }

            return dados
        }
    }

}