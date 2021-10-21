package com.project.movies.ui

import android.app.Application
import com.project.movies.di.AppComponent
import com.project.movies.di.DaggerAppComponent
import com.project.movies.di.modules.AppModule


class App: Application() {

    companion object {
        lateinit var instance: App
    }

    lateinit var appComponent: AppComponent
        private set

    override fun onCreate() {
        super.onCreate()
        instance = this
        appComponent =  DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }

}