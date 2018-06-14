package com.treehouse.smellslikebakin

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlin.math.roundToInt

class GridFragment: Fragment() {

    interface OnRecipeSelectedInterface {
        fun onGridRecipeSelected(index: Int)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val listener = getActivity() as GridFragment.OnRecipeSelectedInterface
        val view = inflater.inflate(R.layout.fragment_recycler_view, container, false)
        val recyclerView = view.findViewById(R.id.recyclerView) as RecyclerView
        val gridAdapter = GridAdapter(listener)
        recyclerView.setAdapter(gridAdapter)
        var displayMetrics: DisplayMetrics = resources.displayMetrics
        var dpWidth: Float = displayMetrics.widthPixels / displayMetrics.density
        val numColumns: Int = (dpWidth / 200).roundToInt()
        val layoutManager = GridLayoutManager(getActivity(), numColumns)
        recyclerView.setLayoutManager(layoutManager)
        return view
    }
}
