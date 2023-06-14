package com.pg13.mycitchen.ui.account

import com.pg13.mycitchen.R
import com.pg13.mycitchen.databinding.FragmentAccountBinding
import com.pg13.mycitchen.ui.base.ViewBindingFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AccountFragment: ViewBindingFragment<FragmentAccountBinding>() {
    override fun getLayoutId() = R.layout.fragment_account
}