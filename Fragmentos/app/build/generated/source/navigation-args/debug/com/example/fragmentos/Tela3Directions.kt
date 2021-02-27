package com.example.fragmentos

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections

public class Tela3Directions private constructor() {
  public companion object {
    public fun tela3ParaTela1(): NavDirections = ActionOnlyNavDirections(R.id.tela3_para_tela1)
  }
}
