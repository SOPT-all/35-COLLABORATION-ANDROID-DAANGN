package org.sopt.carrot.presentation.productDetailScreen.components


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import org.sopt.carrot.R
import org.sopt.carrot.presentation.productDetailScreen.model.UserUiState
import org.sopt.carrot.ui.theme.CarrotTheme


@Composable
fun UserInfoSection(
    userInfo: UserUiState,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row {
            Box(
                modifier = Modifier.size(48.dp),
                contentAlignment = Alignment.BottomEnd
            ) {
                AsyncImage(
                    model = userInfo.profileImage,
                    contentDescription = "프로필 이미지",
                    modifier = Modifier
                        .size(42.dp)
                        .clip(CircleShape)
                        .align(Alignment.TopStart)
                )
                Image(
                    imageVector = ImageVector.vectorResource(id = R.drawable.img_carrier_sm),
                    contentDescription = "캐리어 아이콘",
                    modifier = Modifier
                        .size(19.dp)
                        .offset(x = (-1).dp, y = (-1).dp)
                )
            }
            Spacer(modifier = Modifier.width(10.dp))
            Column(
                modifier = Modifier.height(48.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    modifier = Modifier,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = userInfo.nickname,
                        style = CarrotTheme.typography.body.b_18,
                        color = CarrotTheme.colors.gray8
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    VerticalDivider(
                        modifier = Modifier.height(10.dp),
                        thickness = 1.dp
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = "5시간 전 접속",
                        style = CarrotTheme.typography.body.md_13_18_013,
                        color = CarrotTheme.colors.gray5
                    )
                }
                Text(
                    text = userInfo.address,
                    style = CarrotTheme.typography.body.md_14,
                    color = CarrotTheme.colors.gray8,
                )
            }
        }
        Row(modifier = Modifier.height(48.dp)) {
            Column(
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    painter = painterResource(id = R.drawable.img_user_temperature),
                    contentDescription = "유저 온도"
                )
                Text(
                    text = "매너온도",
                    textDecoration = TextDecoration.Underline,
                    style = CarrotTheme.typography.caption.r_13,
                    color = CarrotTheme.colors.gray6
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun UserInfoSectionPreview() {
    UserInfoSection(
        userInfo = UserUiState(
            nickname = "한민재",
            profileImage = "",
            address = "송파구 삼정동"
        )
    )
}