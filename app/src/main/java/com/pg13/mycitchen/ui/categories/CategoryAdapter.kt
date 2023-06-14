package com.pg13.mycitchen.ui.categories


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.pg13.domain.entities.Category
import com.pg13.mycitchen.R
import com.pg13.mycitchen.databinding.CategoryItemBinding

class CategoryAdapter :
    ListAdapter<Category, CategoryAdapter.CategoryViewHolder>(CategoryDiffCallback) {

    class CategoryViewHolder(val binding: CategoryItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context), R.layout.category_item, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = getItem(position)
        holder.binding.category = category
    }


}

object CategoryDiffCallback : DiffUtil.ItemCallback<Category>() {
    override fun areItemsTheSame(oldItem: Category, newItem: Category): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Category, newItem: Category): Boolean {
        return oldItem.id == newItem.id
    }
}