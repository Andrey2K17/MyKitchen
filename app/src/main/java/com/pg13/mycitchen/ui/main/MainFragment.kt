package com.pg13.mycitchen.ui.main

import com.pg13.mycitchen.R
import com.pg13.mycitchen.databinding.FragmentMainBinding
import com.pg13.mycitchen.ui.base.ViewBindingFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : ViewBindingFragment<FragmentMainBinding>() {
    override fun getLayoutId() = R.layout.fragment_main
}