package com.how.vitamin.ui.main

import android.os.Bundle
import com.how.vitamin.R
import com.how.vitamin.base.BaseActivity
import com.how.vitamin.databinding.ActivityMainBinding
import com.how.vitamin.ui.detail.DetailActivity.Companion.startActivityWithTransition

class MainActivity : BaseActivity() {

    private val binding: ActivityMainBinding by binding(R.layout.activity_main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding.apply {
            lifecycleOwner = this@MainActivity
            adapter = MainAdapter { view, type ->
                startActivityWithTransition(this@MainActivity, view, type)
            }
        }
    }
}