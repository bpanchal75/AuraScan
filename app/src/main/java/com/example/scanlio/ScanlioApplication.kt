package com.example.scanlio

import android.app.Application
import com.google.android.gms.ads.MobileAds

class ScanlioApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        MobileAds.initialize(this) {}
    }
}
