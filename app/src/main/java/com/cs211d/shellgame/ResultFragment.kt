package com.cs211d.shellgame

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import com.cs211d.shellgame.R.*

const val ARG_WIN_STATUS = "winStatus"
const val ARG_BUTTON_CLIcKED = "buttonClicked"

class ResultFragment : Fragment() {

    private lateinit var resultView: View
    private lateinit var imageButtonResult: ImageButton
    var winStatus = false
    var buttonClicked = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Get the winStatus from the fragment arguments
        arguments?.let {
            winStatus = it.getBoolean(ARG_WIN_STATUS)
            buttonClicked= it.getInt(ARG_BUTTON_CLIcKED)
        }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {


        resultView =  inflater.inflate(layout.fragment_result, container, false)

        val resultTextView:TextView = resultView.findViewById(R.id.textview_result)

        imageButtonResult = when(buttonClicked) {
            1 -> resultView.findViewById(R.id.button1_result)
            2 -> resultView.findViewById(R.id.button2_result)
            3 -> resultView.findViewById(R.id.button3_result)
            else -> imageButtonResult
        }

        if(winStatus) {
            imageButtonResult.setImageResource(R.drawable.winning_cup)
            resultTextView.setText(R.string.msg_result_win)
        } else {
            imageButtonResult.rotation = 90F
        }

        return resultView
    }
}