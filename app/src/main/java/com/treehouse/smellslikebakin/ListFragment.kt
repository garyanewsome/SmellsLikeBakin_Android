package com.treehouse.smellslikebakin

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class ListFragment: Fragment() {

    interface OnRecipeSelectedInterface {
        fun onListRecipeSelected(index: Int)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val listener = getActivity() as OnRecipeSelectedInterface
        val view = inflater.inflate(R.layout.fragment_recycler_view, container, false)
        val recyclerView = view.findViewById(R.id.recyclerView) as RecyclerView
        val listAdapter = ListAdapter(listener)
        recyclerView.setAdapter(listAdapter)
        val layoutManager = LinearLayoutManager(getActivity())
        recyclerView.setLayoutManager(layoutManager)
        return view
    }
}