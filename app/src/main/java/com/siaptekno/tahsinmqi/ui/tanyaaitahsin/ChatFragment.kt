package com.siaptekno.tahsinmqi.ui.tanyaaitahsin

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.ai.client.generativeai.GenerativeModel
import com.siaptekno.tahsinmqi.BuildConfig
import com.siaptekno.tahsinmqi.databinding.FragmentChatBinding

class ChatFragment : Fragment() {
    private var _binding: FragmentChatBinding? = null
    val binding get() = _binding!!

    lateinit var viewModel: ChatViewModel
    private var messageAdapter = MessageAdapter()
    private var messageList = mutableListOf<Pair<String, Int>>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentChatBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val geminiAi = GenerativeModel(
            modelName = "gemini-pro",
            apiKey = BuildConfig.GEMINI_API_KEY
        )

        viewModel = ViewModelProvider(
            this,
            ChatViewModel.ChatViewModelFactory(geminiAi)
        ).get(ChatViewModel::class.java)

        setAdapter()
        sendMessage()
        observe()

        binding.toolbar.setNavigationOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }
    }

    private fun setAdapter() {
        val ll = LinearLayoutManager(requireContext())
        ll.stackFromEnd = true
        binding.rcChat.layoutManager = ll
        binding.rcChat.setHasFixedSize(true)
        binding.rcChat.adapter = messageAdapter
    }

    private fun sendMessage() {
        binding.ivSend.setOnClickListener {
            val userMessage = binding.evSend.text.toString().trim()
            viewModel.geminiChat(userMessage)
            messageList.add(Pair(userMessage,MessageAdapter.VIEW_TYPE_USER))
            messageAdapter.setMessages(messageList)
            scrollPosition()
            binding.evSend.setText("")
            binding.imagePromptProgress.visibility = View.VISIBLE
            val inputMethod = requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethod.hideSoftInputFromWindow(it.windowToken,0)
        }
    }
    private fun observe(){
        viewModel.messageResponse.observe(viewLifecycleOwner, Observer { content->
            content.text?.let {
                messageList.add(Pair(it,MessageAdapter.VIEW_TYPE_GEMINI))
                messageAdapter.setMessages(messageList)
                binding.imagePromptProgress.visibility = View.GONE
                scrollPosition()
            }
        })

        // Observer untuk error handling
        viewModel.messageError.observe(viewLifecycleOwner, Observer { errorMessage ->
            if (!errorMessage.isNullOrEmpty()) {
                binding.imagePromptProgress.visibility = View.GONE
                Toast.makeText(requireContext(), errorMessage, Toast.LENGTH_LONG).show()
            }
        })
    }
    private fun scrollPosition(){
        binding.rcChat.smoothScrollToPosition(messageAdapter.itemCount - 1)
    }
}