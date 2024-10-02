package vn.kietnguyendev.ecommerce.di

import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import vn.kietnguyendev.ecommerce.ui.feature.home.HomeViewModel

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
}