package com.gibran.marvelapp.ui.component.hero

import androidx.recyclerview.widget.RecyclerView
import com.gibran.marvelapp.R
import com.gibran.marvelapp.databinding.HeroItemBinding
import com.gibran.marvelapp.ext.loadImage
import com.gibran.marvelapp.ext.standardMediumAvatar
import com.gibran.marvelservice.model.Hero

class HeroListItemViewHolder(private val itemBinding: HeroItemBinding) :
    RecyclerView.ViewHolder(itemBinding.root) {

    fun bind(hero: Hero, onFavoriteClick: (hero: Hero) -> Unit) {
        with(itemBinding) {
            heroName.text = hero.name
            heroAvatar.loadImage(hero.thumbnail.standardMediumAvatar())
            heroFavoriteButton.setOnClickListener {
                onFavoriteClick.invoke(hero.copy(isFavorited = hero.isFavorited.not()))
            }
            if (hero.isFavorited) heroFavoriteButton.setBackgroundResource(R.drawable.ic_favorite_filled)
            else heroFavoriteButton.setBackgroundResource(R.drawable.ic_favorite_border)
        }
    }
}