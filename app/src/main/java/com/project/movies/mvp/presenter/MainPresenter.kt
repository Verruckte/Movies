package com.project.movies.mvp.presenter

import com.project.movies.mvp.view.MainView
import com.project.movies.navigation.Screens
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class MainPresenter: MvpPresenter<MainView>() {

    @Inject
    lateinit var router: Router

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(Screens.MoviesScreen())
    }

    fun backClick() {
        router.exit()
    }


}