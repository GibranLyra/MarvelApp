package com.gibran.marvelapp.ui.component.hero

import androidx.recyclerview.widget.RecyclerView
import com.gibran.marvelapp.databinding.HeroItemBinding
import com.gibran.marvelapp.ext.loadImage
import com.gibran.marvelapp.ext.standardMediumAvatar
import com.gibran.marvelservice.model.Hero

class HeroListItemViewHolder(private val itemBinding: HeroItemBinding) :
    RecyclerView.ViewHolder(itemBinding.root) {

    fun bind(hero: Hero) {
        with(itemBinding) {
            heroName.text = hero.name
            heroAvatar.loadImage(hero.thumbnail.standardMediumAvatar())
        }
    }
}