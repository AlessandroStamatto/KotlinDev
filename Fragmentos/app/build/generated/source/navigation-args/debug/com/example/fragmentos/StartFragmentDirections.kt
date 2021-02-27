package com.example.fragmentos

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections

public class StartFragmentDirections private constructor() {
  public companion object {
    public fun tela1ParaTela2(): NavDirections = ActionOnlyNavDirections(R.id.tela1_para_tela2)
  }
}
