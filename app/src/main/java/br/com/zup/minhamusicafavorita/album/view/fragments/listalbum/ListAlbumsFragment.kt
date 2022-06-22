package br.com.zup.minhamusicafavorita.album.view.fragments.listalbum

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.GridLayoutManager
import br.com.zup.minhamusicafavorita.R
import br.com.zup.minhamusicafavorita.album.model.Album
import br.com.zup.minhamusicafavorita.album.view.fragments.listalbum.adapter.AlbumAdapter
import br.com.zup.minhamusicafavorita.album.viewmodel.AlbumViewModel
import br.com.zup.minhamusicafavorita.databinding.FragmentListAlbumsBinding

class ListAlbumsFragment : Fragment() {
    private lateinit var binding: FragmentListAlbumsBinding
    private val viewModel: AlbumViewModel by lazy {
        ViewModelProvider(this)[AlbumViewModel::class.java]
    }
    private val albumAdapter: AlbumAdapter by lazy {
        AlbumAdapter(mutableListOf(), this::accessDetailAlbum)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListAlbumsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        accessRV()
    }

    private fun observables(){
        viewModel.response.observe(viewLifecycleOwner){
            albumAdapter.atualizarLista(it)
        }
    }

    private fun accessRV(){
        binding.rvAlbum.adapter = albumAdapter
        binding.rvAlbum.layoutManager = GridLayoutManager(context, 2)
        observables()
        viewModel.getAllAlbuns()
    }

    private fun accessDetailAlbum(album: Album){
        val bundle = bundleOf("ALBUM" to album)
        NavHostFragment.findNavController(this).navigate(R.id.action_viewPagerBandFragment_to_detailAlbumFragment, bundle)
    }
}