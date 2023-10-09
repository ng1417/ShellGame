package com.mking.shellgame

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat

class ResultFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_result, container, false)

        val winningID = arguments?.getInt("winningID")!!
        val cupSelected = arguments?.getInt("cupSelected")!!

        val resultTextView0 = rootView.findViewById<TextView>(R.id.result_text_0)
        val resultTextView1 = rootView.findViewById<TextView>(R.id.result_text_1)
        var cup0View = rootView.findViewById<ImageButton>(R.id.result_cup_button_0)
        var cup1View = rootView.findViewById<ImageButton>(R.id.result_cup_button_1)
        var cup2View = rootView.findViewById<ImageButton>(R.id.result_cup_button_2)

        val cupViews: List<ImageButton> = listOf(cup0View, cup1View, cup2View)

        val winningCupDrawable: Drawable? = ContextCompat.getDrawable(requireContext(), R.drawable.winning_cup)

        if (winningID == cupSelected) {
            resultTextView0.text = getString(R.string.result_1_winner)
            resultTextView1.text = getString(R.string.result_2_winner)
        } else {
            resultTextView0.text = getString(R.string.result_1_loser)
            resultTextView1.text = getString(R.string.result_2_loser)
        }

        val matchingCupView = cupViews[winningID]
        matchingCupView.setImageDrawable(winningCupDrawable)

        return rootView
    }

}