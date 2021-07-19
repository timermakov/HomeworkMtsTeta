package com.timermakov.homeworkmtsteta

import android.content.Context

fun calculateImageSizeInPX(context: Context): Pair<Int, Int>? {
    // dots per inch
    val dpi = context.resources.displayMetrics.densityDpi
    // width in dpi from pixels
    val widthDp = convertToDP(context.resources.displayMetrics.widthPixels, dpi)
    // 60 - it's three offsets by 20dp, 2 - two columns
    val imgWidth = (widthDp - 60) / 2
    // width : height = 150 : 216 = 25 : 36
    val imgHeightInPx = convertToPX((imgWidth * 36 / 25.0).toInt(), dpi)
    // if image becomes very huge - not resize it
    if (imgHeightInPx * 3 > context.resources.displayMetrics.heightPixels) {
        return null
    }
    return Pair(
        convertToPX(imgWidth, dpi),
        imgHeightInPx
    )
}

// convert from pixels to dpi
fun convertToDP(value: Int, dpi: Int): Int {
    return (value / (dpi / 160.0)).toInt()
}

// convert from dpi to pixels
fun convertToPX(value: Int, dpi: Int): Int {
    return (value * (dpi / 160.0)).toInt()
}