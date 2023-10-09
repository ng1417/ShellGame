package com.cs211d.shellgame

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.navigation.Navigation
import java.util.*
import java.util.concurrent.TimeUnit


class CupFragment : Fragment() {

    private lateinit var cupView: View
    var buttonClicked = 1
    var args = Bundle()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        cupView = inflater.inflate(R.layout.fragment_cup, container, false)

     override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        cupView = inflater.inflate(R.layout.fragment_cup, container, false)

    /* making the code commented out into a list and a loop
        val imageButton1 = cupView.findViewById<ImageButton>(R.id.button1_cup)
        val imageButton2 = cupView.findViewById<ImageButton>(R.id.button2_cup)
        val imageButton3 = cupView.findViewById<ImageButton>(R.id.button3_cup)

        imageButton1.setOnClickListener(this::onImageButtonClick)
        imageButton2.setOnClickListener(this::onImageButtonClick)
        imageButton3.setOnClickListener(this::onImageButtonClick)
    */
        val buttonIds = listOf(R.id.button1_cup, R.id.button2_cup, R.id.button3_cup)

        buttonIds.forEach { buttonId ->
            val imageButton = cupView.findViewById<ImageButton>(buttonId)
            imageButton.setOnClickListener(this::onImageButtonClick)
        }
        return cupView
    }

        return cupView
    }


    private fun onImageButtonClick(view:View) {

        // determined the button clicked
        buttonClicked = when(view.id) {
            R.id.button1_cup -> 1
            R.id.button2_cup -> 2
            R.id.button3_cup -> 3
            else -> buttonClicked
        }
        args.putInt(ARG_BUTTON_CLIcKED, buttonClicked)

        // determined whether the player win
        val randomGenerator = Random()
        val winStatus = (randomGenerator.nextInt(3) == 0)
        args.putBoolean(ARG_WIN_STATUS, winStatus)

        // navigate to the result page
        Navigation.findNavController(cupView).navigate(R.id.navigation_result, args)


    }

}
