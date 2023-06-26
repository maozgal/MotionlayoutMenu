package com.gal.motionlayoutmanu.utils

import android.content.Context

object DisplayUtils {
    fun dpToPx(dp: Int, context: Context): Int =
        (dp *  context.resources.displayMetrics.density).toInt()
}