package com.cs211d.shellgame

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.Navigation
import com.cs211d.shellgame.R.*

const val ARG_WIN_STATUS = "winStatus"

class ResultFragment : Fragment() {

    private lateinit var resultView: View
    private lateinit var buttonPlay: Button
    var winStatus = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Get the winStatus from the fragment arguments
        arguments?.let { winStatus = it.getBoolean(ARG_WIN_STATUS) }



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        resultView =  inflater.inflate(layout.fragment_result, container, false)
        buttonPlay = resultView.findViewById<Button>(R.id.button_play_game)
        buttonPlay.setOnClickListener{this::onPlayButtonClick}

        if (winStatus) {
            val resultTextView = resultView.findViewById<TextView>(R.id.result_text)
            resultTextView.setText(R.string.msg_win)

        return resultView
    }

    private fun onPlayButtonClick(view:View) {
        Navigation.findNavController(resultView).navigate(R.id.result_to_cup)

    }
}