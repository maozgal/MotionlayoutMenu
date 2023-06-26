package com.gal.threedmenu

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.util.TypedValue
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.core.content.withStyledAttributes
import androidx.core.view.setPadding
import androidx.fragment.app.Fragment
import com.gal.threedmenu.data.MenuItem
import com.gal.threedmenu.utils.DisplayUtils.dpToPx

class MenuView2 @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : FrameLayout(context, attrs) {
    private val rootLayout: MotionLayout
    private val menuLinearLayout: LinearLayout

    private var menuTextColor = Color.BLACK

    init {

        context.withStyledAttributes(attrs, R.styleable.MenuView) {
            menuTextColor = getColor(R.styleable.MenuView_textColor, 0)
        }

        val root = inflate(context, R.layout.main_menu, this)
        rootLayout = root.findViewById(R.id.root)
        menuLinearLayout = rootLayout.findViewById(R.id.menu_linear_layout)

    }

    fun setInitialFragment(fragment: Fragment) {
        setFragment(fragment)
    }

    private fun setFragment(fragment: Fragment) {
        (context as AppCompatActivity).supportFragmentManager.beginTransaction().add(R.id
            .fragment_container, fragment).commit()
    }


    fun setMenuItems(items: ArrayList<MenuItem>) {
        val selectableBackgroundValue = TypedValue()
        context.theme.resolveAttribute(android.R.attr.selectableItemBackground, selectableBackgroundValue, true)

        for (i in items.indices) {
            val itemView = TextView(context)
            itemView.text = items[i].title
            itemView.setPadding(dpToPx(32, context))
            itemView.setTextColor(menuTextColor)

            itemView.setBackgroundResource(selectableBackgroundValue.resourceId)
            itemView.isFocusable = true
            itemView.isClickable = true
            menuLinearLayout.addView(itemView)

            itemView.setOnClickListener {
                setFragment(items[i].fragment.newInstance() as Fragment)
                rootLayout.transitionToStart()
            }
        }
    }
}