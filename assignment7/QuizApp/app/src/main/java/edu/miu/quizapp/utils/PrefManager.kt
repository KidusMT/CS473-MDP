package edu.miu.quizapp.utils

import android.content.Context
import android.content.SharedPreferences

class PrefManager() {
    var pref: SharedPreferences? = null
    var editor: SharedPreferences.Editor? = null
    var _context: Context? = null

    // shared pref mode
    var PRIVATE_MODE = 0

    // Shared preferences file name
    private val PREF_NAME = "quizapp-welcome"

    private val IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch"

    constructor(context: Context?) : this() {
        _context = context
        pref = _context?.getSharedPreferences(PREF_NAME, PRIVATE_MODE)
        editor = pref?.edit()
    }

    fun setFirstTimeLaunch(isFirstTime: Boolean) {
        editor?.putBoolean(IS_FIRST_TIME_LAUNCH, isFirstTime)
        editor?.commit()
    }

    fun isFirstTimeLaunch(): Boolean {
        return pref!!.getBoolean(IS_FIRST_TIME_LAUNCH, true)
    }
}