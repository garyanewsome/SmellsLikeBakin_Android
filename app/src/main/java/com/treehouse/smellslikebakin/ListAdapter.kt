package com.treehouse.smellslikebakin

class ListAdapter(listener:ListFragment.OnRecipeSelectedInterface):RecyclerAdapter() {
    private val mListener:ListFragment.OnRecipeSelectedInterface

    init{
        mListener = listener
    }

    override fun getLayoutId(): Int {
        return R.layout.list_item
    }

    override fun onRecipeSelected(index: Int) {
        mListener.onListRecipeSelected(index)
    }
}
