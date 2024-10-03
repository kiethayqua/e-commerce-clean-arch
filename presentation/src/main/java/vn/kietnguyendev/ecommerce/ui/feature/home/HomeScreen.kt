package vn.kietnguyendev.ecommerce.ui.feature.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import org.koin.androidx.compose.koinViewModel
import vn.kietnguyendev.domain.model.Product
import vn.kietnguyendev.ecommerce.R
import vn.kietnguyendev.ecommerce.ui.theme.C_9B9999
import vn.kietnguyendev.ecommerce.ui.theme.C_F8F7F7

@Composable
fun HomeScreen(viewModel: HomeViewModel = koinViewModel()) {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(top = 20.dp)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(48.dp)
                        .clip(CircleShape)
                        .background(Color.Gray)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Column {
                    Text(text = "Hello!", style = MaterialTheme.typography.bodySmall)
                    Text(text = "Steve Nguyen", style = MaterialTheme.typography.labelLarge)
                }
            }
            Box(modifier = Modifier
                .size(48.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.tertiary),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_noti),
                    contentDescription = null,
                    modifier = Modifier.size(20.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(22.dp))

        Row(modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .height(48.dp)
            .clip(RoundedCornerShape(30.dp))
            .background(C_F8F7F7)
            .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(painter = painterResource(id = R.drawable.ic_search), contentDescription = null)
            Spacer(modifier = Modifier.width(12.dp))
            Text("Search here", style = MaterialTheme.typography.bodySmall, color = C_9B9999)
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