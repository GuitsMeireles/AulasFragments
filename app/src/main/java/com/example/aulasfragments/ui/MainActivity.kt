package com.example.aulasfragments.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.aulasfragments.R
import com.example.aulasfragments.databinding.ActivityMainBinding
import com.example.aulasfragments.fragments.CallsFragment
import com.example.aulasfragments.fragments.ChatFragment
import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val chatFragment = ChatFragment()
    private val callsFragment = CallsFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // define o ChatFragment como fragmento inicial
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_wrapper, chatFragment)
            commit()
        }

        // define o qual fragment abrir de acordo com o item selecionado na navigation bar
        val listener = NavigationBarView.OnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.ic_chat -> changeFragment(chatFragment)
                R.id.ic_calls -> changeFragment(callsFragment)
                else -> false
            }
            true
        }
        binding.bottomNavigation.setOnItemSelectedListener(listener)
        binding.bottomNavigation.selectedItemId = R.id.ic_chat
    }

    // função que troca o fragment
    private fun changeFragment(fragmentToShow: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_wrapper, fragmentToShow)
            commit()
        }
    }
}