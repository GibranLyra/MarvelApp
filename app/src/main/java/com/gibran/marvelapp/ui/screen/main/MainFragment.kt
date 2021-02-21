package com.gibran.marvelapp.ui.screen.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import com.gibran.marvelapp.R
import com.gibran.marvelapp.databinding.MainFragmentBinding
import com.gibran.marvelapp.ui.component.hero.HeroListAdapter
import com.gibran.marvelapp.util.ResultState
import com.gibran.marvelservice.model.Hero
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment(R.layout.main_fragment) {

    private val viewModel by viewModel<MainViewModel>()

    private var _binding: MainFragmentBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    private var restoredStateFilterQuery: String? = null

    private val adapter by lazy {
        HeroListAdapter(
            onClick()
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
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        initViews()
        return binding.root
    }

    private fun initViews() {
        viewModel.fetchHeroes()
        with(binding) {
            errorLayout.tryAgainButton.setOnClickListener { viewModel.fetchHeroes() }
            swipeToRefresh.setOnRefreshListener { viewModel.fetchHeroes() }
            searchBar.setOnFocusChangeListener { _, hasFocus -> showSearchMode(hasFocus) }
            setupSearchMode()
        }
    }

    private fun showSearchMode(isInSearchMode: Boolean) {
        if (isInSearchMode.not()) {
            binding.searchBar.clearFocus()
        }
    }

    private fun setupSearchMode() {
        binding.searchBar.addTextChangedListener {
            if (viewModel.hasHeroes()) {
                setFilteredHeroes(it.toString())
                showFilteredHeroes()
            }
        }
    }

    private fun initViewModel() {
        with(viewModel) {
            heroes.observe(this@MainFragment, { result ->
                when (result) {
                    is ResultState.Error.RecoverableError -> showLoadHeroesError()
                    is ResultState.Error.NonRecoverableError -> showLoadHeroesError()
                    ResultState.Loading -> showLoading()

                    is ResultState.Success -> {
                        if (hasHeroes()) {
                            setupRecyclerView()
                            if (hasRestoredQuery()) {
                                setFilteredHeroes(restoredStateFilterQuery!!)
                                showFilteredHeroes()
                            } else {
                                setHeroes(result.data.toMutableList())
                                showHeroes()
                            }
                        } else {
                            showEmptyState()
                        }
                    }
                }
            })
        }
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

    private fun showLoading() {
        with(binding) {
            loadingLayout.isVisible = true
            errorLayout.root.isVisible = false
            emptyLayout.root.isVisible = false
            successGroup.isVisible = false
        }
    }

    private fun showLoadHeroesError() {
        with(binding) {
            swipeToRefresh.isRefreshing = false
            loadingLayout.isVisible = false
            errorLayout.root.isVisible = true
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

    private fun setFilteredHeroes(query: String) {
        val filteredHeroes = viewModel.getLoadedHeroes()
            .filter { counter ->
                counter.name.contains(query, true)
            }.toMutableList()
        adapter.heroes = filteredHeroes
    }

    private fun showFilteredHeroes() {
        with(binding) {
            swipeToRefresh.isRefreshing = false
            loadingLayout.isVisible = false
            errorLayout.root.isVisible = false
            emptyLayout.root.isVisible = false
            successGroup.isVisible = true
            if (adapter.heroes.isEmpty()) {
                noResultsText.isVisible = true
            } else {
                noResultsText.isVisible = false
                heroesRecyclerView.smoothScrollToPosition(0)
            }
        }
    }

    private fun hasRestoredQuery() = restoredStateFilterQuery.isNullOrEmpty().not()
}