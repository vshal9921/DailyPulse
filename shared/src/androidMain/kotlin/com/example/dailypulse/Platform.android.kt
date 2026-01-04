package com.example.dailypulse

import android.content.res.Resources
import android.os.Build
import android.util.Log

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual class Platform() {
    actual val osName: String
        get() = "Android"
    actual val osVersion: String
        get() = Build.VERSION.SDK_INT.toString()
    actual val deviceModel: String
        get() = Build.MANUFACTURER + " " + Build.MODEL
    actual val density: Int
        get() = Resources.getSystem().displayMetrics.density.toInt()

    actual fun logSystemInfo() {
        Log.d("qwerty", "qwerty - osName = $osName, osVersion = $osVersion, deviceModel = $deviceModel, density = $density")
    }
}