package com.example.lista

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView

class ListaAdapter(val afazerDao : AfazerDao)
    : RecyclerView.Adapter<ListaAdapter.AFazerHolder>() {

    val dados: MutableList<Afazer>
    init {
        //completar! não tá certo:
       dados = mutableListOf()
    }

    class AFazerHolder(v: View, val dados: MutableList<Afazer>)
        : RecyclerView.ViewHolder(v) {

        val titulo: TextView
        val descricao: TextView
        val apagar: Button

        init {
            titulo = v.findViewById(R.id.titulo)
            descricao = v.findViewById(R.id.descricao)
            apagar = v.findViewById(R.id.apagar)

            titulo.setOnClickListener(::detalhes)
            descricao.setOnClickListener(::detalhes)
        }

        fun detalhes(v: View) {
            val dado = dados[adapterPosition]

            v.findNavController().navigate(R.id.lista_para_detalhes)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AFazerHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_lista, parent, false)

        return AFazerHolder(view, dados)
    }

    override fun onBindViewHolder(holder: AFazerHolder, position: Int) {
        holder.titulo.text = dados[position].titulo
        holder.descricao.text = dados[position].descricao

        holder.apagar.setOnClickListener {
            apagar(position)
        }
    }

    override fun getItemCount() = dados.size

    fun apagar(position: Int) {
        val afazer = dados[position]

        //apagar do banco de dados
        //apagar do vetor

        notifyItemRemoved(position)
        notifyItemRangeChanged(position, itemCount - position)
    }

    fun adicionar(titulo: String) {
        val afazer = Afazer(titulo, "Descrição...")

        //adicionar ao banco de dados
        //apagar do banco de dados

        notifyItemInserted(0)
        notifyItemRangeChanged(0, itemCount)
    }

}