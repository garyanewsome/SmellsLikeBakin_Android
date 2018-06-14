package com.treehouse.smellslikebakin

class IngredientsFragment: CheckBoxesFragment() {
    override fun getContents(index: Int): Array<String> {
        return Recipes.ingredients[index].split("`").toTypedArray()
    }
}