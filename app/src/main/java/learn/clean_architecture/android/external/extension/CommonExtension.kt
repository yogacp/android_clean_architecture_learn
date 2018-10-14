package learn.clean_architecture.android.external.extension

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by Yoga C. Pranata on 14/10/2018.
 * Android Engineer
 */
infix fun ViewGroup.inflate(layoutResId: Int): View =
    LayoutInflater.from(context).inflate(layoutResId, this, false)


/**
 * Trim and Replace String
 */
fun String.cropAndReplaceString(length: Int, replace: String): String {
    return if (this.length > length) "${this.substring(0, length)}$replace" else this
}


/**
 * Check if the score is null or not
 */
fun String?.checkScoreNullOrEmpty(): String {
    return if (this.isNullOrEmpty()) "0" else this!!
}