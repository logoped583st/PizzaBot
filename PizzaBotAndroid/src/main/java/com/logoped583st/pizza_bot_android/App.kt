package com.logoped583st.pizza_bot_android

import android.app.Application
import com.logoped583st.pizza_core.di.initKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        initKoin()
    }
}