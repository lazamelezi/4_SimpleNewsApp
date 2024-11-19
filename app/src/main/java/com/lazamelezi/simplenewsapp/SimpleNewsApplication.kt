package com.lazamelezi.simplenewsapp

import com.lazamelezi.simplenews.data.BaseApplication
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class SimpleNewsApplication : BaseApplication() {
    override fun onCreate() {
        super.onCreate()
    }
}
