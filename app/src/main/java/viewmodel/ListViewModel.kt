package viewmodel

import adapter.ModelSites
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import server.RetrofitFactory

class ListViewModel: ViewModel() {
    private var apiService = RetrofitFactory.apiService()
    private var sitesList = MutableLiveData<List<ModelSites>>()

    init {
        requestSites()
    }

    fun getSitesList(): LiveData<List<ModelSites>> = sitesList

    private fun requestSites(){
        viewModelScope.launch {
            sitesList.value = apiService.getAllSites()
        }
    }
}