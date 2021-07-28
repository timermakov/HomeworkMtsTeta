package com.timermakov.homeworkmtsteta.functions

import android.annotation.SuppressLint
import android.view.View
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.timermakov.homeworkmtsteta.R

fun replaceFragment(activity: FragmentActivity, fragment: Fragment, addToBackStack: Boolean) {
    if (addToBackStack) {
        activity.supportFragmentManager.beginTransaction()
            .replace(R.id.mainActivityConstraintLayout, fragment)
            .addToBackStack(null)
            .commit()
    } else {
        activity.supportFragmentManager.beginTransaction()
            .replace(R.id.mainActivityConstraintLayout, fragment)
            .commit()
    }
}

@SuppressLint("UseCompatLoadingForDrawables")
fun setRating(rating: Int, view: View) {
    val context = view.context
    val starList: List<ImageView> = listOf(
        view.findViewById(R.id.firstStar),
        view.findViewById(R.id.secondStar), view.findViewById(R.id.thirdStar),
        view.findViewById(R.id.fourthStar), view.findViewById(R.id.fifthStar)
    )

    for (i in 0 until rating) {
        starList[i].setImageDrawable(context.getDrawable(R.drawable.ic_star_black))
    }
    for (i in 4 downTo rating) {
        starList[i].setImageDrawable(context.getDrawable(R.drawable.ic_star_white))
    }
}
