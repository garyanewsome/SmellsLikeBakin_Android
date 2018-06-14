package com.treehouse.smellslikebakin

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class ViewPagerFragment: Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val index = getArguments()!!.getInt(KEY_RECIPE_INDEX)

        getActivity()!!.setTitle(Recipes.names[index])

        val view = inflater.inflate(R.layout.fragment_viewpager, container, false)
        val ingredientsFragment = IngredientsFragment()

        var bundle = Bundle()
        bundle.putInt(KEY_RECIPE_INDEX, index)
        ingredientsFragment.setArguments(bundle)

        val directionsFragment = DirectionsFragment()
        bundle = Bundle()
        bundle.putInt(KEY_RECIPE_INDEX, index)
        directionsFragment.setArguments(bundle)

        val viewPager = view.findViewById(R.id.viewPager) as ViewPager

        viewPager.setAdapter(object: FragmentPagerAdapter(getChildFragmentManager()) {
            override fun getCount():Int { return 2 }

            override fun getItem(position:Int):Fragment {
                return if (position == 0) ingredientsFragment else directionsFragment
            }
            override fun getPageTitle(position:Int):CharSequence {
                return if (position == 0) "Ingredients" else "Directions"
            }
        })

        val tabLayout = view.findViewById(R.id.tabLayout) as TabLayout
        tabLayout.setupWithViewPager(viewPager)

        return view
    }
    override fun onStop() {
        super.onStop()
        getActivity()!!.setTitle(getResources().getString(R.string.app_name))
    }
    companion object {
        val KEY_RECIPE_INDEX = "recipe_index"
    }
}