package com.treehouse.smellslikebakin

import android.support.v7.widget.RecyclerView

class GridAdapter(listener:GridFragment.OnRecipeSelectedInterface):RecyclerAdapter() {
    private val mListener:GridFragment.OnRecipeSelectedInterface

    init{
        mListener = listener
    }

    override fun getLayoutId(): Int {
        return R.layout.grid_item
    }

    override fun onRecipeSelected(index: Int) {
        mListener.onGridRecipeSelected(index)
    }
}
