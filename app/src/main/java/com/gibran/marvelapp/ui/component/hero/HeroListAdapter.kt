package com.gibran.marvelapp.ui.component.hero

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.gibran.marvelapp.databinding.HeroItemBinding
import com.gibran.marvelservice.model.Hero

class HeroListAdapter(
    private val onClick: (item: Hero) -> Unit
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
        return HeroListItemViewHolder(
            HeroItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: HeroListItemViewHolder, position: Int) {
        setupClickListeners(holder, position)
        holder.bind(heroes[position])
    }

    private fun setupClickListeners(holder: HeroListItemViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            onClick.invoke(heroes[position])
        }
    }

    override fun getItemCount() = heroes.size
}
