package com.mking.shellgame

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.navigation.Navigation


class CupsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_cups, container, false)

        val randomIndex = (0..2).random()

        var cup0View = rootView.findViewById<ImageButton>(R.id.cup_button_0)
        var cup1View = rootView.findViewById<ImageButton>(R.id.cup_button_1)
        var cup2View = rootView.findViewById<ImageButton>(R.id.cup_button_2)

        // Create a list to hold the cup views
        val cupViews = mutableListOf<View>()

        // Add cup views to the list
        cupViews.add(cup0View)
        cupViews.add(cup1View)
        cupViews.add(cup2View)

        // Define a click listener for each cup view
        for (cupView in cupViews) {
            val cupIndex = cupViews.indexOf(cupView)
            cupView.setOnClickListener {
                val bundle = Bundle().apply {
                    putInt("winningID", randomIndex)
                    putInt("cupSelected", cupIndex)
                }

                Navigation.findNavController(cupView).navigate(R.id.action_cups_fragment_to_result_fragment, bundle)
            }

        }

        return rootView
    }

}