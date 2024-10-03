package vn.kietnguyendev.ecommerce.navigation

import vn.kietnguyendev.ecommerce.R

data class TopLevelRoute<T: Any>(val name: String, val route: T, val icon: Int) {
    companion object {
        val topLevelRoutes = listOf(
            TopLevelRoute("Home", Home, R.drawable.ic_home),
            TopLevelRoute("Search", Search, R.drawable.ic_search),
            TopLevelRoute("Cart", Cart, R.drawable.ic_cart),
            TopLevelRoute("Profile", Profile, R.drawable.ic_profile)
        )
    }
}