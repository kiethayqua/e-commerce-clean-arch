package vn.kietnguyendev.data.di

import org.koin.dsl.module
import vn.kietnguyendev.data.repository.ProductRepositoryImpl
import vn.kietnguyendev.domain.repository.ProductRepository

val repositoryModule = module {
    single<ProductRepository> {
        ProductRepositoryImpl(get())
    }
}