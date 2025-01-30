package com.siaptekno.tahsinmqi.ui.tanyaaitahsin

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.google.ai.client.generativeai.Chat
import com.google.ai.client.generativeai.GenerativeModel
import com.google.ai.client.generativeai.type.GenerateContentResponse
import kotlinx.coroutines.launch

class ChatViewModel(geminiPro : GenerativeModel) : ViewModel() {
    private var _messageResponse = MutableLiveData<GenerateContentResponse>()
    val messageResponse : LiveData<GenerateContentResponse> get() = _messageResponse

    private var _messageError = MutableLiveData<String?>() // LiveData untuk error
    val messageError: LiveData<String?> get() = _messageError

    private val geminiChat : Chat = geminiPro.startChat()

    fun geminiChat(message:String){
        viewModelScope.launch {
            try {
                val response = geminiChat.sendMessage(message)
                _messageResponse.value = response
                _messageError.value = null // Reset error jika sukses
            } catch (e: Exception) {
//                _messageError.value = "Error: ${e.message ?: "Terjadi kesalahan, coba lagi nanti"}"
                _messageError.value = "Error: Limit API chat tercapai, coba lagi nanti"
            }
        }
    }

    class ChatViewModelFactory(private val geminiPro : GenerativeModel) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(ChatViewModel::class.java)) {
                return ChatViewModel(geminiPro) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}