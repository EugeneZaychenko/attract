package com.ua.eugenezaychenko.attractez.ui.film_info

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ua.eugenezaychenko.attractez.R
import com.ua.eugenezaychenko.attractez.ui.film_info.models.FilmInfoModel
import kotlinx.android.synthetic.main.fragment_film_info.*

class FilmInfoFragment : Fragment() {

    private val item by lazy {
        arguments?.getParcelable<FilmInfoModel>(FILM_ID_KEY)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_film_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        item?.let { setFilInfo(it) }
    }

    private fun setFilInfo(filmInfoItem: FilmInfoModel) {
        filmInfoItem.apply {
            bitmap?.let { film_info_img.setImageBitmap(it) }
            film_name.text = name
            film_description.text = description
        }
    }

    companion object {

        private const val FILM_ID_KEY = "com.ua.eugenezaychenko.attractez.film.item"

        fun newInstance(item: FilmInfoModel) = FilmInfoFragment().apply {
            arguments = Bundle().apply { putParcelable(FILM_ID_KEY, item) }
        }
    }
}