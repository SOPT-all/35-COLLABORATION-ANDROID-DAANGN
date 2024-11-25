package org.sopt.carrot.presentation.productDetailScreen.components

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.carrot.R
import org.sopt.carrot.core.extension.noRippleClickable
import org.sopt.carrot.ui.theme.CarrotTheme


@Composable
private fun PriceInfo(
    productPrice: String,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(4.dp),
        modifier = modifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = "${productPrice}원",
                style = CarrotTheme.typography.body.b_16_08,
                color = CarrotTheme.colors.gray8
            )
            VerticalDivider(
                modifier = Modifier.height(12.dp),
                thickness = 1.dp,
                color = CarrotTheme.colors.gray3
            )
            Image(
                painter = painterResource(id = R.drawable.img_daangnpay),
                contentDescription = "당근페이 이미지"
            )
        }
        Text(
            text = "가격 제안 불가",
            color = CarrotTheme.colors.gray6,
            style = CarrotTheme.typography.body.b_14
        )
    }
}

@Composable
private fun LikeButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    var isLiked by remember { mutableStateOf(false) }

    Icon(
        modifier = modifier
            .size(28.dp)
            .noRippleClickable {
                isLiked = !isLiked
                onClick()
            },
        imageVector = if (isLiked) {
            ImageVector.vectorResource(id = R.drawable.ic_like_lg_clicked)
        } else {
            ImageVector.vectorResource(id = R.drawable.ic_like_lg_28)
        },
        contentDescription = "찜하기",
        tint = if (isLiked) {
            Color(0xFFFF4F4F) // 빨간색으로 설정
        } else {
            CarrotTheme.colors.gray7 // 기본 색상
        }
    )
}

@Composable
private fun ChatButton(
    modifier: Modifier = Modifier
) {
    Button(
        onClick = { },
        modifier = modifier
            .width(78.dp)
            .height(36.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = CarrotTheme.colors.orange1
        ),
        contentPadding = PaddingValues(0.dp), // 기본 패딩 제거
        shape = RoundedCornerShape(4.dp)
    ) {
        Text(
            text = "채팅하기",
            style = CarrotTheme.typography.body.extb_15,
            color = CarrotTheme.colors.white
        )
    }
}

@Composable
fun ProductBottomBar(
    onLikeClick: () -> Unit,
    productPrice: String,
    modifier: Modifier = Modifier
) {
    Surface(
        color = CarrotTheme.colors.white,
        modifier = modifier
            .fillMaxWidth()
    ) {
        HorizontalDivider(thickness = 1.dp, color = CarrotTheme.colors.gray3)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,  // 수직 중간 정렬로 변경
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                LikeButton(onClick = onLikeClick)

                Spacer(modifier = Modifier.width(12.dp))

                VerticalDivider(
                    modifier = Modifier.height(28.dp),
                    thickness = 1.dp,
                    color = CarrotTheme.colors.gray3
                )

                Spacer(modifier = Modifier.width(12.dp))

                PriceInfo(productPrice = productPrice)
            }

            ChatButton()
        }
    }
}

@Preview
@Composable
private fun ProductBottomBarPreview() {
    ProductBottomBar(
        onLikeClick = {},
        productPrice = "75,000"
    )
}

