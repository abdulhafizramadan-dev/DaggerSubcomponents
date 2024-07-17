package com.gojek.daggersubcomponents

import android.app.Application
import com.gojek.daggersubcomponents.di.ApplicationComponent
import com.gojek.daggersubcomponents.di.DaggerApplicationComponent

class MainApplication: Application() {
    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.create()
    }
}