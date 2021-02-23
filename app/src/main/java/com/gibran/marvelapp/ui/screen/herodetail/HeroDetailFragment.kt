package com.gibran.marvelapp.ui.screen.herodetail

import android.content.Context
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
import com.gibran.marvelapp.ui.BottomBar
import com.gibran.marvelapp.util.ResultState
import com.gibran.marvelservice.model.Hero
import com.google.android.material.snackbar.Snackbar
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

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (requireActivity() is BottomBar) (requireActivity() as BottomBar).showBottomNavigation(false)
    }

    override fun onDetach() {
        super.onDetach()
        if (requireActivity() is BottomBar) (requireActivity() as BottomBar).showBottomNavigation(true)
    }

    private fun initViewModel() {
        with(viewModel) {
            hero.observe(this@HeroDetailFragment, { result ->
                when (result) {
                    is ResultState.Error.NonRecoverableError -> showHeroError()
                    is ResultState.Error.RecoverableError -> showHeroError(result.action)
                    ResultState.Loading -> showLoading()
                    is ResultState.Success -> showHeroDetailsSuccess(result.data)
                }
            })

            favoriteStatus.observe(this@HeroDetailFragment, { result ->
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
        binding.favoriteFab.setOnClickListener {
            viewModel.favoriteHero(hero.copy(isFavorited = hero.isFavorited.not()))
        }
    }

    private fun showHeroDetailsSuccess(hero: Hero) {
        with(binding) {
            loadingLayout.isVisible = false
            errorLayout.root.isVisible = false
            emptyLayout.root.isVisible = false
            heroDetailContainer.isVisible = true
            favoriteFab.isVisible = true

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

    private fun showHeroError(action: (() -> Unit)? = null) {
        with(binding) {
            loadingLayout.isVisible = false
            errorLayout.root.isVisible = true
            errorLayout.tryAgainButton.setOnClickListener { action?.invoke() }
            emptyLayout.root.isVisible = false
            heroDetailContainer.isVisible = false
            favoriteFab.isVisible = false
        }
    }

    private fun showIsFavorited(hero: Hero) {
        this.hero = hero
        setFavoriteButtonStatus(hero)
    }

    private fun showFavoriteError(action: (() -> Unit)? = null) {
        Snackbar.make(
            binding.heroDetailContainer,
            getString(R.string.favorite_hero_error_message),
            Snackbar.LENGTH_SHORT
        ).setAction(R.string.try_again) {
            action?.invoke()
        }.show()
    }

    private fun setFavoriteButtonStatus(hero: Hero) {
        with(binding) {
            if (hero.isFavorited) favoriteFab.setImageDrawable(
                ContextCompat.getDrawable(requireContext(), R.drawable.ic_favorite_filled)
            )
            else favoriteFab.setImageDrawable(
                ContextCompat.getDrawable(requireContext(), R.drawable.ic_favorite_border)
            )
        }
    }
}