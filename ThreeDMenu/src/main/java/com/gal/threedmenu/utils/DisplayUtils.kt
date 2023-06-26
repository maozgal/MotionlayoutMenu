package com.gal.threedmenu.utils

import android.content.Context

object DisplayUtils {
    fun dpToPx(dp: Int, context: Context): Int =
        (dp *  context.resources.displayMetrics.density).toInt()
}