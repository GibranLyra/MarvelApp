package com.gibran.marvelapp.ui.component.hero

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.gibran.marvelservice.model.Hero

class HeroListAdapter(
    onClick: (item: Hero) -> Unit
) : RecyclerView.Adapter<HeroListItemViewHolder>() {
    var heroes = mutableListOf<Hero>()
        set(value) {
            DiffUtil.calculateDiff(HeroListDiffCallback(field, value))
                .apply { dispatchUpdatesTo(this@HeroListAdapter) }
            field = value
        }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HeroListItemViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: HeroListItemViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

}
