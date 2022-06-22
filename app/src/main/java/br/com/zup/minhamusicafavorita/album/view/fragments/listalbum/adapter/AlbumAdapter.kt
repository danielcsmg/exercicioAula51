package br.com.zup.minhamusicafavorita.album.view.fragments.listalbum.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.zup.minhamusicafavorita.album.model.Album
import br.com.zup.minhamusicafavorita.databinding.CardAlbumBinding

class AlbumAdapter(
    var listAlbum: MutableList<Album>,
    val clickCardAlbum: (album: Album) -> Unit
): RecyclerView.Adapter<AlbumAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = CardAlbumBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val album = listAlbum[position]
        holder.showInformations(album)
        holder.binding.cvAlbum.setOnClickListener{
            clickCardAlbum(album)
        }
    }

    override fun getItemCount() = listAlbum.size

    fun atualizarLista(newListAlbum: List<Album>){
        listAlbum.addAll(newListAlbum)
    }

    class ViewHolder(val binding: CardAlbumBinding): RecyclerView.ViewHolder(binding.root) {
        fun showInformations(album: Album){
            binding.ivFotoAlbum.setImageResource(album.fotoAlbum)
        }
    }

}