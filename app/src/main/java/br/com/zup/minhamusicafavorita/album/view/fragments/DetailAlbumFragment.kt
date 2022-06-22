package br.com.zup.minhamusicafavorita.album.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import br.com.zup.minhamusicafavorita.R
import br.com.zup.minhamusicafavorita.album.model.Album
import br.com.zup.minhamusicafavorita.album.view.activity.HomeActivity
import br.com.zup.minhamusicafavorita.databinding.FragmentDetailAlbumBinding

class DetailAlbumFragment : Fragment() {
    private lateinit var binding: FragmentDetailAlbumBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailAlbumBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        alterAppBar()
        val album = arguments?.getParcelable<Album>("ALBUM")
        showInfomations(album)
    }

    private fun setData(textView: TextView, campo: Int, texto: String){
        textView.text = getString(campo, texto)
    }

    private fun favoriteAlbum(album: Album){
        binding.ivFavorito.setOnClickListener{
            if (!album.favorito){
                Toast.makeText(context, "Favoritado com sucesso", Toast.LENGTH_LONG).show()
                album.favorito = true
            }
        }
    }

    private fun showInfomations(album: Album?){
        album?.let {
            binding.ivAlbum.setImageResource(album.fotoAlbum)
            binding.tvTitulo.text = album.nomeDoAlbum
            binding.tvDescricaoAlbum.text = album.descricaoDoAlbum
            setData(binding.tvArtista, R.string.artista, album.artista)
            setData(binding.tvLancamento, R.string.lancamento, album.lancamento.toString())
            setData(binding.tvGravadora, R.string.gravadora, album.gravadora)
            setData(binding.tvEstudio, R.string.estudio, album.estudio)
            setData(binding.tvFormato, R.string.formato, album.formato)
            setData(binding.tvGenero, R.string.genero, album.generos)
            favoriteAlbum(album)
        }
    }

    private fun alterAppBar(){
        (activity as HomeActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (activity as HomeActivity).supportActionBar?.title = "Detalhes do Album"
    }
}