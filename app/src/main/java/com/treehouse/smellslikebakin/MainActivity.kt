package com.treehouse.smellslikebakin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.util.Log
import android.widget.GridLayout
import android.widget.Toast

class MainActivity:AppCompatActivity(), ListFragment.OnRecipeSelectedInterface, GridFragment.OnRecipeSelectedInterface {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val isTablet:Boolean = resources.getBoolean(R.bool.is_tablet)
        if (!isTablet) {
            val savedFragment:ListFragment? = supportFragmentManager.findFragmentByTag(LIST_FRAGMENT) as? ListFragment

            if (savedFragment == null) {
                val fragment = ListFragment()
                val fragmentManager = getSupportFragmentManager()
                val fragmentTransaction = fragmentManager.beginTransaction()
                fragmentTransaction.add(R.id.placeholder, fragment, LIST_FRAGMENT)
                fragmentTransaction.commit()
            }
        } else {
            val savedFragment:GridFragment? = supportFragmentManager.findFragmentByTag(LIST_FRAGMENT) as? GridFragment

            if (savedFragment == null) {
                val fragment = GridFragment()
                val fragmentManager = getSupportFragmentManager()
                val fragmentTransaction = fragmentManager.beginTransaction()
                fragmentTransaction.add(R.id.placeholder, fragment, LIST_FRAGMENT)
                fragmentTransaction.commit()
            }
        }
    }

    override fun onListRecipeSelected(index: Int) {
        val fragment = ViewPagerFragment()
        val bundle = Bundle()
        bundle.putInt(ViewPagerFragment.KEY_RECIPE_INDEX, index)
        fragment.setArguments(bundle)
        val fragmentManager = getSupportFragmentManager()
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.placeholder, fragment, VIEWPAGER_FRAGMENT)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

    override fun onGridRecipeSelected(index: Int){
        val fragment = DualPaneFragment()
        val bundle = Bundle()
        bundle.putInt(ViewPagerFragment.KEY_RECIPE_INDEX, index)
        fragment.setArguments(bundle)
        val fragmentManager = getSupportFragmentManager()
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.placeholder, fragment, VIEWPAGER_FRAGMENT)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

    companion object {
        val LIST_FRAGMENT = "list_fragment"
        val VIEWPAGER_FRAGMENT = "viewpager_fragment"
//        val DUALPANE_FRAGMENT = "dualpane_fragment"
    }
}
