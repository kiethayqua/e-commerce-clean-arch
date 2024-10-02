package vn.kietnguyendev.ecommerce.ui.feature.home

import vn.kietnguyendev.domain.model.Product

sealed class HomeScreenUIEvents {
    data object Loading: HomeScreenUIEvents()
    data class Success(val data: List<Product>): HomeScreenUIEvents()
    data class Error(val message: String): HomeScreenUIEvents()
}