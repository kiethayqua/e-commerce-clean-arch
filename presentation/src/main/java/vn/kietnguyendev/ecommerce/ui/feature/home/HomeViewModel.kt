package vn.kietnguyendev.ecommerce.ui.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import vn.kietnguyendev.domain.model.Product
import vn.kietnguyendev.domain.network.ResultWrapper
import vn.kietnguyendev.domain.usecase.GetProductUseCase

class HomeViewModel(private val getProductUseCase: GetProductUseCase): ViewModel() {

    private val _uiState = MutableStateFlow<HomeScreenUIEvents>(HomeScreenUIEvents.Loading)
    val uiState = _uiState.asStateFlow()

    init {
        getProducts()
    }

    private fun getProducts() {
        viewModelScope.launch {
            getProductUseCase().let { result ->
                when (result) {
                    is ResultWrapper.Success -> {
                        _uiState.value = HomeScreenUIEvents.Success(result.value)
                    }

                    is ResultWrapper.Failure -> {
                        _uiState.value = HomeScreenUIEvents.Error(result.exception.message ?: "")
                    }
                }
            }
        }
    }

}