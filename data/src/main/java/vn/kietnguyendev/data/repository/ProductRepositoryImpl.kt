package vn.kietnguyendev.data.repository

import vn.kietnguyendev.domain.model.Product
import vn.kietnguyendev.domain.network.NetworkService
import vn.kietnguyendev.domain.network.ResultWrapper
import vn.kietnguyendev.domain.repository.ProductRepository

class ProductRepositoryImpl(private val networkService: NetworkService): ProductRepository {
    override suspend fun getProducts(category: String?): ResultWrapper<List<Product>> {
        return networkService.getProducts(category)
    }
}