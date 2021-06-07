package com.github.sasakitomohiro.dfmsample

import android.app.Application
import android.content.Context
import com.google.android.play.core.splitcompat.SplitCompat

class App : Application() {
    override fun attachBaseContext(context: Context) {
        super.attachBaseContext(context)
        SplitCompat.install(context)
    }
}
