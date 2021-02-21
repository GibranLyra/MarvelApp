package com.gibran.marvelapp.ui.component.hero

import androidx.recyclerview.widget.DiffUtil
import com.gibran.marvelservice.model.Hero

class HeroListDiffCallback(
    private val oldList: List<Hero>,
    private val newList: List<Hero>
) : DiffUtil.Callback() {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}