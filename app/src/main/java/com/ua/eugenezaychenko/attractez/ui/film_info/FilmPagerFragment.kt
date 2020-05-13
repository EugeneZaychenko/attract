package com.ua.eugenezaychenko.attractez.ui.film_info

import android.os.Bundle
import android.view.View
import com.ua.eugenezaychenko.attractez.App
import com.ua.eugenezaychenko.attractez.R
import com.ua.eugenezaychenko.attractez.ui.film_info.models.FilmInfoModel
import com.ua.eugenezaychenko.attractez.utils.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_pager.*
import javax.inject.Inject


class FilmPagerFragment : BaseFragment(), FilmPagerContract.View {

    @Inject
    lateinit var presenter: FilmPagerContract.Presenter

    private var pagerAdapter: PagerAdapter? = null

    private val filmPosition by lazy {
        arguments?.getInt(KEY_CURRENT_FILM_POSITION, DEFAULT_FILM_POSITION) ?: DEFAULT_FILM_POSITION
    }

    override val viewResource = R.layout.fragment_pager

    override fun injectDependencies(): Unit? = App.filmInfoComponent?.inject(this)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.bindView(this)
        presenter.init()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.end()
    }

    override fun updatePagerList(filmIdList: List<FilmInfoModel>) {
        if (pagerAdapter == null) initPager(filmIdList)
        else pagerAdapter?.addButch(filmIdList)
    }

    private fun initPager(filmIdList: List<FilmInfoModel>) {
        pagerAdapter = PagerAdapter(filmIdList = filmIdList.toMutableList(), fm = childFragmentManager)
        view_pager.adapter = pagerAdapter
        pagerAdapter?.addButch(filmIdList)
        view_pager.currentItem = filmPosition
    }

    override fun showError(msg: String) {
        showToast(msg)
    }

    companion object {
        private const val KEY_CURRENT_FILM_POSITION = "com.ua.eugenezaychenko.attractez.film.position"
        private const val DEFAULT_FILM_POSITION = 0

        fun newInstance(filmPosition: Int) = FilmPagerFragment().apply {
            arguments = Bundle().apply { putInt(KEY_CURRENT_FILM_POSITION, filmPosition) }
        }
    }

}