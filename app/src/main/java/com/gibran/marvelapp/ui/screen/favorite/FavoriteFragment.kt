package com.gibran.marvelapp.ui.screen.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.gibran.marvelapp.R
import com.gibran.marvelapp.databinding.FavoriteFragmentBinding
import com.gibran.marvelapp.ui.component.hero.HeroListAdapter
import com.gibran.marvelapp.util.ResultState
import com.gibran.marvelservice.model.Hero
import com.google.android.material.snackbar.Snackbar
import org.koin.androidx.viewmodel.ext.android.viewModel

class FavoriteFragment : Fragment(R.layout.favorite_fragment) {

    private val viewModel by viewModel<FavoriteViewModel>()

    private var _binding: FavoriteFragmentBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    private val adapter by lazy {
        HeroListAdapter(
            onClick(), onFavoriteClick()
        )
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewModel()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FavoriteFragmentBinding.inflate(inflater, container, false)
        initViews()
        return binding.root
    }

    private fun initViews() {
        viewModel.fetchFavoriteHeroes()
        with(binding) {
            errorLayout.tryAgainButton.setOnClickListener { viewModel.fetchFavoriteHeroes() }
            swipeToRefresh.setOnRefreshListener { viewModel.fetchFavoriteHeroes() }
        }
    }

    private fun initViewModel() {
        with(viewModel) {
            heroes.observe(this@FavoriteFragment, { result ->
                when (result) {
                    is ResultState.Error.RecoverableError -> showLoadHeroesError(result.action)
                    is ResultState.Error.NonRecoverableError -> showLoadHeroesError()
                    ResultState.Loading -> showLoading()

                    is ResultState.Success -> {
                        if (hasHeroes()) {
                            setupRecyclerView()
                            setHeroes(result.data.toMutableList())
                            showHeroes()
                        } else {
                            showEmptyState()
                        }
                    }
                }
            })

            favoriteStatus.observe(this@FavoriteFragment, { result ->
                when (result) {
                    is ResultState.Error.NonRecoverableError -> showFavoriteError()
                    is ResultState.Error.RecoverableError -> showFavoriteError(result.action)
                    ResultState.Loading -> {
                        //Do Nothing
                    }
                    is ResultState.Success -> showIsFavorited(result.data)
                }
            })
        }
    }

    private fun showIsFavorited(hero: Hero) {
        adapter.remove(hero)
    }

    private fun showFavoriteError(action: (() -> Unit)? = null) {
        Snackbar.make(
            binding.favoriteContainer,
            getString(R.string.favorite_hero_error_message),
            Snackbar.LENGTH_SHORT
        ).setAction(R.string.try_again) {
            action?.invoke()
        }.show()
    }

    private fun setupRecyclerView() {
        if (binding.heroesRecyclerView.adapter == null) {
            binding.heroesRecyclerView.setHasFixedSize(true)
            binding.heroesRecyclerView.adapter = adapter
        }
    }

    private fun onClick(): (item: Hero) -> Unit = {
        //TODO
    }

    private fun onFavoriteClick(): (hero: Hero) -> Unit = {
        viewModel.favoriteHero(it)
    }

    private fun showLoading() {
        with(binding) {
            loadingLayout.isVisible = true
            errorLayout.root.isVisible = false
            emptyLayout.root.isVisible = false
            successGroup.isVisible = false
        }
    }

    private fun showLoadHeroesError(action: (() -> Unit)? = null) {
        with(binding) {
            swipeToRefresh.isRefreshing = false
            loadingLayout.isVisible = false
            errorLayout.root.isVisible = true
            errorLayout.tryAgainButton.setOnClickListener { action?.invoke() }
            emptyLayout.root.isVisible = false
            successGroup.isVisible = false
        }
    }

    private fun showEmptyState() {
        with(binding) {
            swipeToRefresh.isRefreshing = false
            loadingLayout.isVisible = false
            errorLayout.root.isVisible = false
            emptyLayout.root.isVisible = true
            successGroup.isVisible = false
        }
    }

    private fun setHeroes(heroes: MutableList<Hero>) {
        adapter.heroes = heroes
    }

    private fun showHeroes() {
        with(binding) {
            swipeToRefresh.isRefreshing = false
            loadingLayout.isVisible = false
            errorLayout.root.isVisible = false
            emptyLayout.root.isVisible = false
            successGroup.isVisible = true
        }
    }
}