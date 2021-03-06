package com.example.lista

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room

class TelaLista : Fragment() {

    lateinit var db: AppDatabase

    override fun onAttach(context: Context) {
        super.onAttach(context)

        //pegar banco de dados
        db = Room.databaseBuilder(
            context, //acesso ao "aplicativo" (Activity Principal)
            AppDatabase::class.java, //use esse esquema de banco de dados
            "listadb") //o banco de dados se chama assim
            .allowMainThreadQueries() //permita eu engasgar a tela
            .build() //vai!
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tela_lista, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val lista: RecyclerView = view.findViewById(R.id.listaView)
        lista.layoutManager = LinearLayoutManager(context)
        lista.addItemDecoration(
                DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        )

        val adaptador = ListaAdapter(db.afazerDao())
        lista.adapter = adaptador

        val novoAfazer: TextView = view.findViewById(R.id.novoAfazer)
        val botaoAdicionar: Button = view.findViewById(R.id.adicionar)

        botaoAdicionar.setOnClickListener {
            adaptador.adicionar(novoAfazer.text.toString())
            hideKeyboard()
        }
    }

    fun hideKeyboard() {
        val inputManager: InputMethodManager = this.requireActivity()
                .getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

        // check if no view has focus:
        val currentFocusedView = this.requireActivity().currentFocus
        if (currentFocusedView != null) {
            inputManager.hideSoftInputFromWindow(
                    currentFocusedView.windowToken,
                    InputMethodManager.HIDE_NOT_ALWAYS
            )
        }
    }
}