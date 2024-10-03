package vn.kietnguyendev.domain.usecase

import vn.kietnguyendev.domain.repository.ProductRepository

class GetProductUseCase(private val repository: ProductRepository) {
    suspend operator fun invoke(category: String?) = repository.getProducts(category)
}