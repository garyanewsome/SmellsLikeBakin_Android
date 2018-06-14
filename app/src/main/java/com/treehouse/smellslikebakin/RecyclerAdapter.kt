package com.treehouse.smellslikebakin

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.util.Log

abstract class RecyclerAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent:ViewGroup, viewType:Int):RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.getContext()).inflate(getLayoutId(), parent, false)
        return ListViewHolder(view)
    }

    abstract fun getLayoutId(): Int

    override fun onBindViewHolder(holder:RecyclerView.ViewHolder, position:Int) {
        (holder as ListViewHolder).bindView(position)
    }

    override fun getItemCount() = Recipes.names.size

    private inner class ListViewHolder(itemView:View):RecyclerView.ViewHolder(itemView), View.OnClickListener {
        private val mTextView:TextView = itemView.findViewById(R.id.itemText) as TextView
        private val mImageView:ImageView = itemView.findViewById(R.id.itemImage) as ImageView
        private var mIndex:Int = 0

        init{
            itemView.setOnClickListener(this)
        }

        fun bindView(position:Int) {
            mIndex = position
            mTextView.text = Recipes.names[position]
            mImageView.setImageResource(Recipes.resourceIds[position])
        }

        override fun onClick(v:View) {
            onRecipeSelected(mIndex)
        }
    }
    abstract fun onRecipeSelected(index: Int)
}