package com.pg13.mycitchen.ui.categories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pg13.domain.entities.Categories
import com.pg13.domain.entities.Resource
import com.pg13.domain.usecases.GetCategoriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoriesViewModel @Inject constructor(
    private val getCategoriesUseCase: GetCategoriesUseCase
) : ViewModel() {

    private val refreshEvent = MutableSharedFlow<Unit>(1)

    val categories: Flow<Resource<Categories>> =
        refreshEvent
            .flatMapLatest { getCategoriesUseCase.invoke() }

    fun getCategories() {
        viewModelScope.launch {
            refreshEvent.emit(Unit)
            cancel()
        }
    }
}