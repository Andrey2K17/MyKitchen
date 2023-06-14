package com.pg13.mycitchen.ui.categories

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import com.pg13.domain.entities.Resource
import com.pg13.mycitchen.R
import com.pg13.mycitchen.databinding.FragmentMainBinding
import com.pg13.mycitchen.ui.base.ViewBindingFragment
import com.pg13.mycitchen.ui.rv.VerticalSpaceItemDecoration
import com.pg13.mycitchen.utils.launchOnLifecycle
import com.pg13.mycitchen.utils.showErrorDialog
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : ViewBindingFragment<FragmentMainBinding>() {
    override fun getLayoutId() = R.layout.fragment_main

    private val viewModel: CategoriesViewModel by viewModels()

    private val adapter: CategoryAdapter by lazy {
        CategoryAdapter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getCategories()

        with(binding) {
            recyclerView.adapter = adapter
            recyclerView.addItemDecoration(
                VerticalSpaceItemDecoration(
                    requireContext().resources.getDimensionPixelSize(
                        R.dimen.padding_8dp
                    )
                )
            )

            launchOnLifecycle {
                viewModel.categories.collect { resource ->
                    when (resource) {
                        is Resource.Error -> {
                            binding.refreshLayout.isRefreshing = false
                            resource.message?.let { showErrorDialog(it) }
                        }
                        is Resource.Loading -> {
                            refreshLayout.isRefreshing = true
                        }
                        is Resource.Success -> {
                            adapter.submitList(resource.data.categories)
                            refreshLayout.isRefreshing = false
                        }
                    }
                }
            }

            refreshLayout.setOnRefreshListener {
                viewModel.getCategories()
            }
        }
    }
}