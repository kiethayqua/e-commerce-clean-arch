package vn.kietnguyendev.domain.di

import org.koin.dsl.module
import vn.kietnguyendev.domain.usecase.GetProductUseCase

val useCaseModule = module {
    factory { GetProductUseCase(get()) }
}