package com.treehouse.smellslikebakin

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class DualPaneFragment: Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val index = getArguments()!!.getInt(ViewPagerFragment.KEY_RECIPE_INDEX)

        getActivity()!!.setTitle(Recipes.names[index])

        val view = inflater.inflate(R.layout.fragment_dualpane, container, false)

        val fragmentManager: FragmentManager = childFragmentManager
        val savedIngredientsFragment: IngredientsFragment? = fragmentManager.findFragmentByTag(INGREDIENTS_FRAGMENT) as? IngredientsFragment
        if (savedIngredientsFragment == null) {
            val ingredientsFragment = IngredientsFragment()
            val bundle = Bundle()
            bundle.putInt(ViewPagerFragment.KEY_RECIPE_INDEX, index)
            ingredientsFragment.setArguments(bundle)
            fragmentManager.beginTransaction().add(R.id.leftPlaceholder, ingredientsFragment, INGREDIENTS_FRAGMENT).commit()
        }

        val savedDirectionsFragment: DirectionsFragment? = fragmentManager.findFragmentByTag(DIRECTIONS_FRAGMENT) as? DirectionsFragment

        if (savedDirectionsFragment == null) {
            val directionsFragment = DirectionsFragment()
            val bundle = Bundle()
            bundle.putInt(ViewPagerFragment.KEY_RECIPE_INDEX, index)
            directionsFragment.setArguments(bundle)
            fragmentManager.beginTransaction().add(R.id.rightPlaceholder, directionsFragment, DIRECTIONS_FRAGMENT).commit()
        }

        return view
    }

    override fun onStop() {
        super.onStop()
        getActivity()!!.setTitle(getResources().getString(R.string.app_name))
    }

    companion object {
        private val INGREDIENTS_FRAGMENT = "ingredients_fragment"
        private val DIRECTIONS_FRAGMENT = "key_directions_fragment"
    }
}