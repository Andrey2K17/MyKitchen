package com.pg13.mycitchen.ui.search

import com.pg13.mycitchen.R
import com.pg13.mycitchen.databinding.FragmentSearchBinding
import com.pg13.mycitchen.ui.base.ViewBindingFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : ViewBindingFragment<FragmentSearchBinding>() {
    override fun getLayoutId() = R.layout.fragment_search
}