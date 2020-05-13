package com.ua.eugenezaychenko.attractez.ui.film_list

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.ua.eugenezaychenko.attractez.App
import com.ua.eugenezaychenko.attractez.R
import com.ua.eugenezaychenko.attractez.ui.callbacks.IActivityHelper
import com.ua.eugenezaychenko.attractez.ui.film_list.adapter.FilmAdapter
import com.ua.eugenezaychenko.attractez.ui.film_list.model.FilmListItemModel
import com.ua.eugenezaychenko.attractez.utils.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_film_list.*
import javax.inject.Inject


class FilmListFragment : BaseFragment(), FilmListContract.View {

    @Inject
    lateinit var presenter: FilmListContract.Presenter

    private val filmAdapter = FilmAdapter(::onItemSelected)

    override val viewResource = R.layout.fragment_film_list

    override fun injectDependencies() = App.filmListComponent?.inject(this)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
        presenter.bindView(this)
        presenter.init()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.end()
    }

    override fun updateFilList(filmList: List<FilmListItemModel>) {
        filmAdapter.addButch(filmList)
    }

    override fun showProgressBar() {
        showProgressbarDialog()
    }

    override fun hideProgressBar() {
        hideProgressbarDialog()
    }

    override fun showError(msg: String) {
        showToast(msg)
    }

    private fun initUI() {
        film_list_rv.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = filmAdapter
        }
    }

    private fun onItemSelected(position: Int) {
        (activity as? IActivityHelper)?.showFilmInfoPagerFragment(position)
    }

    companion object {
        fun newInstance() = FilmListFragment()
    }
}