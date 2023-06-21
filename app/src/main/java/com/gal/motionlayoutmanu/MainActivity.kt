package com.gal.motionlayoutmanu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.constraintlayout.helper.widget.Flow
import androidx.constraintlayout.motion.widget.MotionLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        supportFragmentManager.beginTransaction().add(R.id.fragment_container, MainFragment())
//            .commit()

//        val root: MotionLayout = findViewById(R.id.root)
//        val flow: Flow = findViewById(R.id.flow)
//        val textView = TextView(this)
//        textView.id = 78787878
//        textView.text="gggg"
//        flow.referencedIds += textView.id
//        root.addView(textView)
//        val menu =
//        root.addView(textView)
    }
}