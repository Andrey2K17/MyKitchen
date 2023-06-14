package com.pg13.mycitchen.ui.cart

import com.pg13.mycitchen.R
import com.pg13.mycitchen.databinding.FragmentCartBinding
import com.pg13.mycitchen.ui.base.ViewBindingFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CartFragment : ViewBindingFragment<FragmentCartBinding>() {
    override fun getLayoutId() = R.layout.fragment_cart
}