package br.com.zup.minhamusicafavorita.album.view.viewpagerband

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import br.com.zup.minhamusicafavorita.album.view.activity.HomeActivity
import br.com.zup.minhamusicafavorita.album.view.viewpagerband.adapter.BandAdapter
import br.com.zup.minhamusicafavorita.databinding.FragmentViewPagerAlbumBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class ViewPagerBandFragment : Fragment() {
    private lateinit var binding: FragmentViewPagerAlbumBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentViewPagerAlbumBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        alterAppBar()
        val tabLayout = binding.tlInformacoes
        val viewPager = binding.vpInformacoesBanda
        val supportFragmentManager = (activity as HomeActivity).supportFragmentManager
        viewPager.adapter = BandAdapter(supportFragmentManager, lifecycle)
        setTabLayout(tabLayout, viewPager)
    }

    private fun setTabLayout(tabLayout: TabLayout, viewPager2: ViewPager2) {
        TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
            when (position) {
                0 -> tab.text = "Informações"
                1 -> tab.text = "Álbuns"
            }
        }.attach()
    }


    private fun alterAppBar() {
        (activity as HomeActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (activity as HomeActivity).supportActionBar?.title = "Informações da Banda"
    }
}