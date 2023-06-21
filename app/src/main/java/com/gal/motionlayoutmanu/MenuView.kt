package com.gal.motionlayoutmanu

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.fragment.app.Fragment
import com.gal.motionlayoutmanu.data.MenuItem

class MenuView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : FrameLayout(context, attrs) {
    private var rootLayout: MotionLayout
    init {
        val root = inflate(context, R.layout.main_manu, this)
        rootLayout = root.findViewById<MotionLayout>(R.id.root)
        (context as AppCompatActivity).supportFragmentManager.beginTransaction().add(R.id
            .fragment_container,
            MainFragment())
            .commit()

        val menuItem = MenuItem("aaa",MainFragment::class.java)
        val menuItem2 = MenuItem("bbb",MainFragment2::class.java)

        root.findViewById<TextView>(R.id.show).text = menuItem.title
        root.findViewById<TextView>(R.id.main).text = menuItem2.title

        root.findViewById<TextView>(R.id.show).setOnClickListener {
            (context as AppCompatActivity).supportFragmentManager.beginTransaction().add(R.id
                .fragment_container,
                menuItem.fragment.newInstance() as Fragment)
                .commit()
            root.findViewById<MotionLayout>(R.id.root).transitionToStart()
        }

        root.findViewById<TextView>(R.id.main).setOnClickListener {
            (context as AppCompatActivity).supportFragmentManager.beginTransaction().add(R.id
                .fragment_container,
                menuItem2.fragment.newInstance() as Fragment)
                .commit()
            root.findViewById<MotionLayout>(R.id.root).transitionToStart()
        }

//        setMenuItems(arrayListOf())
    }

    fun setMenuItems(items: ArrayList<MenuItem>) {
        val set = ConstraintSet()
        set.clone(rootLayout)
//        for (i in items.indices) {
            val itemView = TextView(context)
            itemView.text = "GGGGG"
            itemView.id = View.generateViewId()
            rootLayout.addView(itemView,0)
            set.connect(itemView.id, ConstraintSet.TOP, rootLayout.id, ConstraintSet.TOP, 60);
//        }
        set.applyTo(rootLayout)
    }
}