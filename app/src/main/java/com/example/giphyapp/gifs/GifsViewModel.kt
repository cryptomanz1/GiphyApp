package com.example.giphyapp.gifs

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.giphyapp.data.Data
import com.example.giphyapp.service.GiphyService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GifsViewModel @Inject constructor(private val service: GiphyService) : ViewModel() {
    val viewData = MutableLiveData<List<Data>>()
    val progress = MutableLiveData<Boolean>()
    val error = MutableLiveData<String>()

    init {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                progress.postValue(true)
                val gifs = service.getGifs()
                service.getGifs()
                viewData.postValue(gifs)
                progress.postValue(false)
            } catch (e: Exception) {
                e.printStackTrace()
                error.postValue("Error: ${e.message}")
                progress.postValue(false)
            }
        }
    }
}