package com.example.android2extrahomework2.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android2extrahomework2.databinding.ActivityMainBinding
import com.example.android2extrahomework2.ui.adapters.ViewPagerAdapter
import com.example.android2extrahomework2.ui.fragments.OneFragment
import com.example.android2extrahomework2.ui.fragments.TwoFragment
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var oneFragment=  OneFragment()
    private var twoFragment =  TwoFragment()

    private val fragList = listOf(
        oneFragment,
        twoFragment
        )

    private val fragListNames = listOf(
        "Item1",
        "Item2"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initialize()
    }

    private fun initialize() {
        val adapter = ViewPagerAdapter(this, fragList)
        binding.vp.adapter = adapter

        TabLayoutMediator(binding.tableLayout, binding.vp){
                tab,pos -> tab.text = fragListNames[pos]
        }.attach()
    }
}