package com.ua.eugenezaychenko.attractez.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ua.eugenezaychenko.attractez.App
import com.ua.eugenezaychenko.attractez.R
import com.ua.eugenezaychenko.attractez.ui.callbacks.IActivityHelper
import com.ua.eugenezaychenko.attractez.ui.film_info.FilmPagerFragment
import com.ua.eugenezaychenko.attractez.ui.film_list.FilmListFragment
import com.ua.eugenezaychenko.attractez.utils.replace
import com.ua.eugenezaychenko.attractez.utils.replaceWithBackStack

class OperationActivity : AppCompatActivity(), IActivityHelper {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        App.operationComponent?.inject(this)

        if (savedInstanceState == null) showFilmList()

    }

    private fun showFilmList() {
        replace(R.id.fragment_container, FilmListFragment.newInstance())
    }

    override fun showFilmInfoPagerFragment(position: Int) {
        replaceWithBackStack(R.id.fragment_container, FilmPagerFragment.newInstance(position))
    }

}
