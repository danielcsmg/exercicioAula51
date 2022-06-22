package br.com.zup.minhamusicafavorita.album.view.viewpagerband.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import br.com.zup.minhamusicafavorita.album.view.fragments.BandFragment
import br.com.zup.minhamusicafavorita.album.view.fragments.listalbum.ListAlbumsFragment


class BandAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle
) : FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount() = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> BandFragment()
            1 -> ListAlbumsFragment()
            else -> BandFragment()
        }
    }

}