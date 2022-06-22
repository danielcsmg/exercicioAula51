package br.com.zup.minhamusicafavorita.album.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import br.com.zup.minhamusicafavorita.R
import br.com.zup.minhamusicafavorita.album.view.activity.HomeActivity
import br.com.zup.minhamusicafavorita.databinding.FragmentFavoriteMusicBinding

class FavoriteMusicFragment : Fragment() {
    private lateinit var binding: FragmentFavoriteMusicBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavoriteMusicBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        alterAppBar()
        navigateToViewPagerBand()
    }

    private fun navigateToViewPagerBand() {
        binding.btnDetalhes.setOnClickListener {
            NavHostFragment.findNavController(this).navigate(R.id.action_favoriteMusicFragment_to_viewPagerBandFragment)
        }
    }

    private fun alterAppBar() {
        (activity as HomeActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)
        (activity as HomeActivity).supportActionBar?.title = "Música Favorita"
    }
}