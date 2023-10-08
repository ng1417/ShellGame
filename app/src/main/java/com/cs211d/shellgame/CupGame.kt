package com.cs211d.shellgame

import java.util.*

class CupGame {

    var winnercup:Int = 0

    fun newGame() {
        val randomNumberGenerator = Random()
        winnercup = randomNumberGenerator.nextInt(3) + 1
    }

    fun isGameWin(cupId:Int): Boolean {
        return winnercup == cupId
    }

}