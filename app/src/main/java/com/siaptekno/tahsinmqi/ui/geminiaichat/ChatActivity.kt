package com.siaptekno.tahsinmqi.ui.geminiaichat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction
import com.siaptekno.tahsinmqi.R
import com.siaptekno.tahsinmqi.databinding.ActivityChatBinding

class ChatActivity : AppCompatActivity() {
    private var  _binding : ActivityChatBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityChatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragment = ChatFragment()

        val ft : FragmentTransaction = supportFragmentManager.beginTransaction()

        ft.replace(R.id.ft,fragment)
            .addToBackStack(null)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()
    }
}