package com.lenovo.mutimodeshow.bean

import android.app.Application

class MyApplication :Application() {
    companion object{
        public lateinit var context:Application
    }

    override fun onCreate() {
        super.onCreate()
        context=this
    }
}