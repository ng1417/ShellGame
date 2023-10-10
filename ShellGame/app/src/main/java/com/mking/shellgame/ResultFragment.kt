package com.mking.shellgame

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment

private var winCount = 0


class ResultFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_result, container, false)

        val winningID = arguments?.getInt("winningID")!!
        val cupSelected = arguments?.getInt("cupSelected")!!

        val textViewIds = listOf(R.id.result_text_0, R.id.result_text_1, R.id.result_text_2)
        val resultTextViews = textViewIds.map { rootView.findViewById<TextView>(it) }

        val cupImages: List<ImageButton> = listOf(
            rootView.findViewById(R.id.result_cup_button_0),
            rootView.findViewById(R.id.result_cup_button_1),
            rootView.findViewById(R.id.result_cup_button_2)
        )
        val winningCupDrawable: Drawable? = ContextCompat.getDrawable(requireContext(), R.drawable.winning_cup)

        if (winningID == cupSelected) {
            winCount++
            resultTextViews[0].text = getString(R.string.result_1_winner)
            resultTextViews[1].text = getString(R.string.result_2_winner)
        } else {
            resultTextViews[0].text = getString(R.string.result_1_loser)
            resultTextViews[1].text = getString(R.string.result_2_loser)
        }

        //print numbers of wins
        val countMessage = getString(R.string.win_count_message, winCount)
        resultTextViews[2].text = countMessage

        val matchingCup = cupImages[winningID]
        matchingCup.setImageDrawable(winningCupDrawable)
        return rootView
    }

}