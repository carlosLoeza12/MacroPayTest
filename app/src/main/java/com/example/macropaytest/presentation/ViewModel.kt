package com.example.macropaytest.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.macropaytest.data.model.Response
import com.example.macropaytest.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class ViewModel @Inject constructor(private val repository: Repository): ViewModel(){

    private val loginResponse = MutableLiveData<Response>()
    val _loginResponse: LiveData<Response>
    get() = loginResponse

    private val responseMsg = MutableLiveData<Boolean>()
    val _responseMsg: LiveData<Boolean>
        get() = responseMsg

    fun makeLogin(email: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = repository.makeLogin(email, password)
                loginResponse.postValue(response)

            } catch (e: Exception) {
                Log.e("error", e.message ?: "")
            }
        }
    }
}