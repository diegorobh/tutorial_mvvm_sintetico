package com.example.testdiegoandroid.Repositories

import android.content.Context
import android.preference.PreferenceManager

class DeviceDataRepository(context: Context) {
    var prefs = PreferenceManager.getDefaultSharedPreferences(context)
    var sharePreferences = prefs.edit()
    init {
        setOrderStatus(getOrderStatus())
    }
    fun setOrderStatus(number: Int){
        sharePreferences.putInt("orderStatus", number)
        sharePreferences.commit()
    }
    fun getOrderStatus(): Int = run {
        prefs.getInt("orderStatus", 0)
    }
}