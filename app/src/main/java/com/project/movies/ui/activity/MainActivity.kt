package com.project.movies.ui.activity

import android.os.Bundle
import com.project.movies.R
import com.project.movies.mvp.presenter.MainPresenter
import com.project.movies.mvp.view.MainView
import com.project.movies.ui.App
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter

class MainActivity : MvpAppCompatActivity(), MainView {

    val presenter by moxyPresenter {
        App.instance.appComponent.inject(this)

        MainPresenter().apply {
            App.instance.appComponent.inject(this)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        App.instance.appComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

}