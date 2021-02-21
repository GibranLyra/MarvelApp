package com.gibran.marvelapp.ui.component.hero

import androidx.recyclerview.widget.RecyclerView
import com.gibran.marvelapp.databinding.HeroItemBinding
import com.gibran.marvelservice.model.Hero

class HeroListItemViewHolder(private val itemBinding: HeroItemBinding) :
    RecyclerView.ViewHolder(itemBinding.root) {

    fun bind(hero: Hero, onClick: (item: Hero) -> Unit) {
        with(itemBinding) {
            //TODO
        }
    }
}