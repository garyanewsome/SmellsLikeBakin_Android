package com.treehouse.smellslikebakin

class DirectionsFragment: CheckBoxesFragment() {
    override fun getContents(index: Int): Array<String> {
        return Recipes.directions[index].split("`").toTypedArray()
    }
}