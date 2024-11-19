package com.lazamelezi.simplenews.data

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager



@Suppress("DEPRECATION")
open class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        instances = this
    }

    companion object {
        lateinit var instances: BaseApplication

        fun isNetworkConnected(): Boolean {
            val connectivityManager =
                instances.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val networkInfo = connectivityManager.activeNetworkInfo
            return networkInfo != null && networkInfo.isConnected
        }
    }
}
