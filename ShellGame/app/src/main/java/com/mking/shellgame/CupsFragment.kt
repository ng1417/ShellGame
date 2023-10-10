package com.mking.shellgame

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.navigation.Navigation


class CupsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_cups, container, false)

        val randomIndex = (0..2).random()

        var cup0 = rootView.findViewById<ImageButton>(R.id.cup_button_0)
        var cup1 = rootView.findViewById<ImageButton>(R.id.cup_button_1)
        var cup2 = rootView.findViewById<ImageButton>(R.id.cup_button_2)

        // Create a list to hold the cup views
        // just fewer words for readability
        val cups = mutableListOf<View>()

        // Add cup views to the list
        cups.add(cup0)
        cups.add(cup1)
        cups.add(cup2)

        // Define a click listener for each cup view
        for (cup in cups) {
            val cupIndex = cups.indexOf(cup)
            cup.setOnClickListener {
                val bundle = Bundle().apply {
                    putInt("winningID", randomIndex)
                    putInt("cupSelected", cupIndex)
                }

                Navigation.findNavController(cup).navigate(R.id.action_cups_fragment_to_result_fragment, bundle)
            }

        }

        return rootView
    }

}