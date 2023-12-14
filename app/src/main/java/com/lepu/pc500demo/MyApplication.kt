package com.lepu.pc500demo

import android.app.Application
import com.CommonApp.init
import com.net.KoinInit.koinStart
import com.net.util.LogUtil

/**
 * 说明: java
 * zrj 2022/3/24 15:18
 */
class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        init(this)
        koinStart(this)
        LogUtil.init(this)
    }
}
