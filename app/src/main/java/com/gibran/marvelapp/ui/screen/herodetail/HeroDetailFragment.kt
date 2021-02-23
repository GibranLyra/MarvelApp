package com.gibran.marvelapp.ui.screen.herodetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.gibran.marvelapp.R
import com.gibran.marvelapp.databinding.HeroDetailFragmentBinding
import com.gibran.marvelapp.ext.landscapeLargeAvatar
import com.gibran.marvelapp.ext.loadImage
import com.gibran.marvelapp.util.ResultState
import com.gibran.marvelservice.model.Hero
import org.koin.androidx.viewmodel.ext.android.viewModel

class HeroDetailFragment : Fragment(R.layout.hero_detail_fragment) {
    private val viewModel by viewModel<HeroDetailViewModel>()

    private var _binding: HeroDetailFragmentBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    private val args: HeroDetailFragmentArgs by navArgs()
    private lateinit var hero: Hero

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hero = args.heroArgs
        initViewModel()
    }

    private fun initViewModel() {
        with(viewModel) {
            hero.observe(this@HeroDetailFragment, { result ->
                when (result) {
                    is ResultState.Error.NonRecoverableError -> showLoadHeroesError()
                    is ResultState.Error.RecoverableError -> showLoadHeroesError()
                    ResultState.Loading -> showLoading()
                    is ResultState.Success -> {
                        showHeroDetailsSuccess(result.data)
                    }
                }
            })
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = HeroDetailFragmentBinding.inflate(inflater, container, false)
        initViews()
        return binding.root
    }

    private fun initViews() {
        viewModel.fetchHeroDetail(hero)
    }

    private fun showHeroDetailsSuccess(hero: Hero) {
        with(binding) {
            loadingLayout.isVisible = false
            errorLayout.root.isVisible = false
            emptyLayout.root.isVisible = false
            heroDetailContainer.isVisible = true
            favoriteFab.isVisible = true

            if (hero.isFavorited) favoriteFab.setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.ic_favorite_filled))
            else favoriteFab.setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.ic_favorite_border))

            heroDescription.text = hero.description
            collapsingToolbarBanner.loadImage(hero.thumbnail.landscapeLargeAvatar())
        }
    }

    private fun showLoading() {
        with(binding) {
            loadingLayout.isVisible = true
            errorLayout.root.isVisible = false
            emptyLayout.root.isVisible = false
            heroDetailContainer.isVisible = false
            favoriteFab.isVisible = false
        }
    }

    private fun showLoadHeroesError() {
        with(binding) {
            loadingLayout.isVisible = false
            errorLayout.root.isVisible = true
            emptyLayout.root.isVisible = false
            heroDetailContainer.isVisible = false
            favoriteFab.isVisible = false
        }
    }

    private fun showEmptyState() {
        with(binding) {
            loadingLayout.isVisible = false
            errorLayout.root.isVisible = false
            emptyLayout.root.isVisible = true
            heroDetailContainer.isVisible = false
            favoriteFab.isVisible = false
        }
    }
}