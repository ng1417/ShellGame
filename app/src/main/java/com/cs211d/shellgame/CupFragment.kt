package com.cs211d.shellgame

import android.os.Bundle
import android.os.PersistableBundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.navigation.Navigation
import java.util.*
import java.util.concurrent.TimeUnit


class CupFragment : Fragment() {

    private lateinit var gameView: View
    var winStatus = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        gameView = inflater.inflate(R.layout.fragment_cup, container, false)

        // Set listener on radioButton Changes
        val radioButton = gameView.findViewById<RadioGroup>(R.id.button_group)
        radioButton.setOnCheckedChangeListener(this::onRadioButtonClick)

        return gameView
    }


    private fun onRadioButtonClick(radioGroup:RadioGroup, checkedId:Int) {

        // decide whether this cup contains a ball
        val randomNumberGenerator = Random()
        winStatus = (randomNumberGenerator.nextInt(3) == 0)

        val radioButton = gameView.findViewById<RadioButton>(checkedId)

        if (winStatus) {
            radioButton.setBackgroundResource(R.drawable.winning_cup)
        } else {
            radioButton.rotation = 90F
        }

        // wait 2 seconds before displaying the result
        //TimeUnit.SECONDS.sleep(2L)

        val args = Bundle()
        args.putBoolean(ARG_WIN_STATUS, winStatus)
        Navigation.findNavController(gameView).navigate(R.id.cup_to_result, args)

    }

}
