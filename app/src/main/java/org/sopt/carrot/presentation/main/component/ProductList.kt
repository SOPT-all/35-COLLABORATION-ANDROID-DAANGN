package org.sopt.carrot.presentation.main.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import org.sopt.carrot.R
import org.sopt.carrot.domain.model.HomeProduct
import org.sopt.carrot.ui.theme.CarrotTheme

@Composable
fun ProductList(items: List<HomeProduct>, listState: LazyListState) {
    LazyColumn(
        modifier = Modifier.padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        state = listState,
        contentPadding = PaddingValues(
            top = 16.dp,
            bottom = 72.dp
        )
    ) {
        itemsIndexed(items, key = { _, item -> item.id }) { index, item ->
            ProductItemCard(item = item)
            if (index != items.lastIndex) {
                HorizontalDivider(
                    Modifier.fillMaxWidth(),
                    color = CarrotTheme.colors.gray2,
                    thickness = 1.dp
                )
            }
        }
    }
}

@Composable
fun ProductItemCard(item: HomeProduct) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { }
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = item.productImage,
            contentDescription = null,
            modifier = Modifier
                .size(108.dp)
                .clip(RoundedCornerShape(6.dp))
                .background(Color.White),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.width(16.dp))

        Column(
            modifier = Modifier.weight(1f)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = item.title,
                    style = CarrotTheme.typography.body.md_17,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Icon(
                    painter = painterResource(id = R.drawable.ic_menu_kebab_gray_18),
                    contentDescription = "",
                )
            }

            Spacer(modifier = Modifier.height(6.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (!item.distance.isNullOrEmpty()) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_location_12),
                        contentDescription = null,
                        tint = CarrotTheme.colors.gray6
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = item.distance,
                        style = CarrotTheme.typography.body.md_14_03,
                        color = CarrotTheme.colors.gray6
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                }
                Text(
                    text = "${item.address} · ${item.time}",
                    style = CarrotTheme.typography.body.md_14_03,
                    color = CarrotTheme.colors.gray6
                )
            }

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = "${item.price}원",
                style = CarrotTheme.typography.body.sb_17_08,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End
            ) {
                if (!item.chat.isNullOrEmpty()) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_chat_sm_18),
                        contentDescription = null,
                        tint = Color.Unspecified
                    )
                    Text(
                        text = item.chat.toString(),
                        style = CarrotTheme.typography.body.md_14
                    )
                }
                Spacer(modifier = Modifier.width(2.dp))
                Icon(
                    painter = painterResource(id = R.drawable.ic_like_sm_18),
                    contentDescription = null,
                    tint = Color.Unspecified
                )
                Text(
                    text = item.view.toString(),
                    style = CarrotTheme.typography.body.md_14
                )
            }
        }
    }
}
