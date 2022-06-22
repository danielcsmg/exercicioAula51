package br.com.zup.minhamusicafavorita.album.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.zup.minhamusicafavorita.album.model.Album
import br.com.zup.minhamusicafavorita.album.repository.AlbumRepository

class AlbumViewModel(): ViewModel() {
    private val repository = AlbumRepository()
    private val _response: MutableLiveData<List<Album>> = MutableLiveData()
    val response: LiveData<List<Album>> = _response

    fun getAllAlbuns(){
        try{
            _response.value = repository.getListAlbum()
        }catch (e: Exception){
            Log.i("Error", "-------> ${e.message}")
        }
    }
}