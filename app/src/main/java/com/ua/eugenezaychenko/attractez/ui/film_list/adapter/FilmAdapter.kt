package com.ua.eugenezaychenko.attractez.ui.film_list.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ua.eugenezaychenko.attractez.R
import com.ua.eugenezaychenko.attractez.ui.film_list.model.FilmListItemModel
import com.ua.eugenezaychenko.attractez.utils.inflateView
import kotlinx.android.synthetic.main.item_film.view.*

class FilmAdapter constructor(private val onItemSelected: (position: Int) -> Unit,
                              private val itemList: MutableList<FilmListItemModel> = mutableListOf())
    : RecyclerView.Adapter<FilmAdapter.FilmListViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmListViewHolder =
            FilmListViewHolder(parent.inflateView(R.layout.item_film))

    override fun getItemCount(): Int = itemList.size

    override fun onBindViewHolder(holder: FilmListViewHolder, position: Int) {
        holder.bind(itemList[position])
    }

    fun addButch(list: List<FilmListItemModel>) {
        itemList.clear()
        itemList.addAll(list)
        notifyDataSetChanged()
    }

    inner class FilmListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        init {
            itemView.setOnClickListener { if (isClickAvailable()) onItemSelected(adapterPosition) }
        }

        fun bind(item: FilmListItemModel) = itemView.apply {
            item.img?.let {
                item_film_img.setImageBitmap(it)
            } ?: item_film_img.setImageResource(R.drawable.ic_cloud_off)
            item_film_tv_name.text = item.name
            item_film_tv_date.text = item.dateStr
        }

        private fun isClickAvailable(): Boolean = adapterPosition in 0..itemList.lastIndex

    }

}