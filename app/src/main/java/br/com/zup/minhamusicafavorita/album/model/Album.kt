package br.com.zup.minhamusicafavorita.album.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Album(
    val fotoAlbum: Int,
    val nomeDoAlbum: String,
    val descricaoDoAlbum: String,
    val artista: String,
    val lancamento: Int,
    val gravadora: String,
    val estudio: String,
    val formato: String,
    val generos: String,
    var favorito: Boolean = false
): Parcelable