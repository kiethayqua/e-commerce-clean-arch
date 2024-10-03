package vn.kietnguyendev.ecommerce.ui.feature.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.koin.androidx.compose.koinViewModel
import vn.kietnguyendev.domain.model.Product

@Composable
fun HomeScreen(viewModel: HomeViewModel = koinViewModel()) {
    val uiState = viewModel.uiState.collectAsState()

    when(uiState.value) {
        is HomeScreenUIEvents.Loading -> {
            CircularProgressIndicator()
        }

        is HomeScreenUIEvents.Success -> {
            val data = (uiState.value as HomeScreenUIEvents.Success)
        }

        is HomeScreenUIEvents.Error -> {
            Text(text = (uiState.value as HomeScreenUIEvents.Error).message)
        }
    }
}

@Composable
fun ProductItem(product: Product) {
    Card(modifier = Modifier.padding(8.dp)) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(text = product.title, style = MaterialTheme.typography.titleLarge)
                Text(text = "$${product.price}", style = MaterialTheme.typography.bodyMedium)
            }
        }
    }
}