package edu.miu.CVBuilderApp.utils

import android.content.Context
import android.content.SharedPreferences
import edu.miu.CVBuilderApp.ui.activity.MainActivity

object Utils {
    val LIGHT = "light"
    val DARK = "dark"
}

private lateinit var sharedPref: SharedPreferences

class AppUtils {
    companion object {
        @JvmStatic
        fun setPref(activity: MainActivity): SharedPreferences {
            sharedPref = activity.getPreferences(Context.MODE_PRIVATE)
            return sharedPref
        }

        fun getPref(key: String): String? {
            return sharedPref.getString(key, "")
        }
    }
}


