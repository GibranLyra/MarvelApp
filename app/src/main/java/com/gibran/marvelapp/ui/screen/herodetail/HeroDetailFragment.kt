package com.gibran.marvelapp.ui.screen.herodetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.gibran.marvelapp.R
import com.gibran.marvelapp.databinding.HeroDetailFragmentBinding
import com.gibran.marvelservice.model.Hero
import org.koin.androidx.viewmodel.ext.android.viewModel

class HeroDetailFragment: Fragment(R.layout.hero_detail_fragment) {
    private val viewModel by viewModel<HeroDetailViewModel>()

    private var _binding: HeroDetailFragmentBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    private val args: HeroDetailFragmentArgs by navArgs()
    private lateinit var hero: Hero

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewModel()
    }

    private fun initViewModel() {
        TODO("Not yet implemented")
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

}