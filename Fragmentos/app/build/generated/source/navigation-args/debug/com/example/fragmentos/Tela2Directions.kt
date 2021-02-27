package com.example.fragmentos

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections

public class Tela2Directions private constructor() {
  public companion object {
    public fun tela2ParaTela3(): NavDirections = ActionOnlyNavDirections(R.id.tela2_para_tela3)
  }
}
