package com.gal.motionlayoutmanu

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gal.threedmenu.data.MenuItem
import com.gal.threedmenu.MenuView2

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val menu = findViewById<MenuView2>(R.id.menu)
        menu.setInitialFragment(MainFragment2())
        menu.setMenuItems(arrayListOf(MenuItem("AAAAA",MainFragment::class.java),
            MenuItem("AAAAA",MainFragment::class.java),MenuItem("AAAAA",MainFragment::class.java),
            MenuItem("AAAAA",MainFragment::class.java),
            MenuItem("AAAAA",MainFragment::class.java),
            MenuItem("AAAAA",MainFragment::class.java),
            MenuItem("AAAAA",MainFragment::class.java),
            MenuItem("AAAAA",MainFragment::class.java),
            MenuItem("AAAAA",MainFragment::class.java),
            MenuItem("AAAAA",MainFragment::class.java),
            MenuItem("AAAAA",MainFragment::class.java),
            MenuItem("AAAAA",MainFragment::class.java),
            MenuItem("AAAAA",MainFragment::class.java),
            MenuItem("AAAAA",MainFragment::class.java),
            MenuItem("AAAAA",MainFragment::class.java),
            MenuItem("AAAAA",MainFragment::class.java),
            MenuItem("AAAAA",MainFragment::class.java),
        ))
    }
}