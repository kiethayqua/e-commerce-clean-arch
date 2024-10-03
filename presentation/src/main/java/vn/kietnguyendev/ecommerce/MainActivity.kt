package vn.kietnguyendev.ecommerce

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import vn.kietnguyendev.ecommerce.navigation.Cart
import vn.kietnguyendev.ecommerce.navigation.Home
import vn.kietnguyendev.ecommerce.navigation.Profile
import vn.kietnguyendev.ecommerce.navigation.Search
import vn.kietnguyendev.ecommerce.navigation.TopLevelRoute
import vn.kietnguyendev.ecommerce.ui.feature.cart.CartScreen
import vn.kietnguyendev.ecommerce.ui.feature.home.HomeScreen
import vn.kietnguyendev.ecommerce.ui.feature.profile.ProfileScreen
import vn.kietnguyendev.ecommerce.ui.feature.search.SearchScreen
import vn.kietnguyendev.ecommerce.ui.theme.ECommerceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ECommerceTheme {
                val navController = rememberNavController()
                Scaffold(
                    bottomBar = {
                        BottomNavigation(
                            modifier = Modifier.navigationBarsPadding(),
                            backgroundColor = Color.White
                        ) {
                            val navBackStackEntry by navController.currentBackStackEntryAsState()
                            val currentDestination = navBackStackEntry?.destination
                            TopLevelRoute.topLevelRoutes.forEach { topLevelRoute ->
                                val selected = currentDestination?.hierarchy?.any {
                                    it.hasRoute(
                                        topLevelRoute.route::class
                                    )
                                } == true

                                BottomNavigationItem(
                                    icon = {
                                        Image(
                                            painter = painterResource(id = topLevelRoute.icon),
                                            contentDescription = null,
                                            colorFilter = ColorFilter.tint(if (selected) MaterialTheme.colorScheme.primary  else MaterialTheme.colorScheme.secondary)
                                        )
                                    },
                                    label = null,
                                    selected = selected,
                                    onClick = {
                                        navController.navigate(topLevelRoute.route) {
                                            // Pop up to the start destination of the graph to
                                            // avoid building up a large stack of destinations
                                            // on the back stack as users select items
                                            popUpTo(navController.graph.findStartDestination().id) {
                                                saveState = true
                                            }
                                            // Avoid multiple copies of the same destination when
                                            // reselecting the same item
                                            launchSingleTop = true
                                            // Restore state when reselecting a previously selected item
                                            restoreState = true
                                        }
                                    }
                                )
                            }
                        }
                    }
                ) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = Home,
                        modifier = Modifier.padding(bottom = innerPadding.calculateBottomPadding(), top = innerPadding.calculateTopPadding())
                    ) {
                        composable<Home> {
                            HomeScreen()
                        }
                        composable<Search> {
                            SearchScreen()
                        }
                        composable<Cart> {
                            CartScreen()
                        }
                        composable<Profile> {
                            ProfileScreen()
                        }
                    }
                }
            }
        }
    }
}