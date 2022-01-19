package dev.amol.daggerapidemo.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.amol.daggerapidemo.data.remote.responsedata.ResponseData
import dev.amol.daggerapidemo.repository.DaggerDemoRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DaggerDemoViewModel @Inject constructor(val repo:DaggerDemoRepository):ViewModel() {


    val articleListData = MutableLiveData<ResponseData>()

    fun getAPIData() {
       viewModelScope.launch {
             val responseData = repo.fetchData()
           articleListData.value=responseData
       }
    }
}