package com.ua.eugenezaychenko.attractez.ui.film_info

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.ua.eugenezaychenko.attractez.ui.film_info.models.FilmInfoModel

class PagerAdapter constructor(private val filmIdList: MutableList<FilmInfoModel> = mutableListOf(),
                               fm: FragmentManager) : FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment {
        val model = filmIdList[position]
        return FilmInfoFragment.newInstance(model)
    }

    override fun getCount(): Int = filmIdList.size

    fun addButch(list: List<FilmInfoModel>) {
        filmIdList.clear()
        filmIdList.addAll(list)
        notifyDataSetChanged()
    }

}