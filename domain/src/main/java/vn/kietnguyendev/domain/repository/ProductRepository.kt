package vn.kietnguyendev.domain.repository

import vn.kietnguyendev.domain.model.Product
import vn.kietnguyendev.domain.network.ResultWrapper

interface ProductRepository {
    suspend fun getProducts(category: String?): ResultWrapper<List<Product>>
}