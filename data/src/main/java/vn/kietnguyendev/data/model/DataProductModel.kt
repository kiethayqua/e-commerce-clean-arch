package vn.kietnguyendev.data.model

import kotlinx.serialization.Serializable
import vn.kietnguyendev.domain.model.Product

@Serializable
data class DataProductModel(
    val id: Long,
    val title: String,
    val price: Double,
    val category: String,
    val description: String,
    val image: String
) {
    fun toProduct() = Product(
        id = id,
        title = title,
        price = price,
        category = category,
        description = description,
        image = image
    )
}