package com.treehouse.smellslikebakin

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.LinearLayout

abstract class CheckBoxesFragment:Fragment() {
    private var mCheckBoxes = arrayOf<CheckBox?>()
    private var KEY_CHECK_BOXES:String = "key_checked_boxes"

    override fun onCreateView(inflator: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val index:Int = arguments!!.getInt(ViewPagerFragment.KEY_RECIPE_INDEX)

        val view = inflator.inflate(R.layout.fragment_checkboxes, container, false)

        val linearLayout: LinearLayout = view.findViewById(R.id.checkBoxesLayout) as LinearLayout

        var contents: Array<String> = getContents(index)

        mCheckBoxes = arrayOfNulls<CheckBox>(contents.size)
        var checkedBoxes = BooleanArray(mCheckBoxes!!.size)
        if (savedInstanceState != null && savedInstanceState.getBoolean(KEY_CHECK_BOXES) != null) {
            checkedBoxes = savedInstanceState.getBooleanArray(KEY_CHECK_BOXES)
        }
        setUpCheckBoxes(contents, linearLayout, checkedBoxes)
        return view
    }

    abstract fun getContents(index:Int):Array<String>

    private fun setUpCheckBoxes(contents: Array<String>, container: ViewGroup, checkBoxes: BooleanArray) {
        var i = 0
        for (content in contents) {
            mCheckBoxes[i] = CheckBox(activity)
            mCheckBoxes[i]!!.setPadding(8, 16, 8, 16)
            mCheckBoxes[i]!!.setTextSize(20f)
            mCheckBoxes[i]!!.setText(content)
            container.addView(mCheckBoxes[i])
            if (checkBoxes[i]) {
                mCheckBoxes[i]!!.toggle()
            }
            i++
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        val stateOfCheckBoxes = BooleanArray(mCheckBoxes.size)
        var i = 0
        for (checkBox in mCheckBoxes){
            stateOfCheckBoxes[i] = checkBox!!.isChecked()
            i++
        }
        outState.putBooleanArray(KEY_CHECK_BOXES, stateOfCheckBoxes)
        super.onSaveInstanceState(outState)
    }
}