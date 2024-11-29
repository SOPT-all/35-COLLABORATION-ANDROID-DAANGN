package org.sopt.carrot.presentation.sellerProfile.component.section

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import org.sopt.carrot.R
import org.sopt.carrot.core.extension.noRippleClickable
import org.sopt.carrot.domain.model.UserDetail
import org.sopt.carrot.ui.theme.CarrotTheme

@Composable
fun SellerProfileSection(
    onFollowClick: () -> Unit,
    sellerProfile: UserDetail
) {
    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .padding(top = 24.dp, bottom = 28.dp)
    ) {
        Row(
            modifier = Modifier.padding(bottom = 15.dp)
        ) {
            Box(
                contentAlignment = Alignment.BottomEnd
            ) {
                if (sellerProfile.profileImage.isNullOrEmpty()) {
                    Image(
                        imageVector = ImageVector.vectorResource(R.drawable.img_user_lg),
                        contentDescription = null
                    )
                } else {
                    AsyncImage(
                        model = sellerProfile.profileImage,
                        contentDescription = "프로필 이미지",
                        modifier = Modifier
                            .size(62.dp)
                            .clip(CircleShape)
                    )
                }
                Image(
                    imageVector = ImageVector.vectorResource(R.drawable.img_carrier_md),
                    contentDescription = null
                )
            }

            Column(
                modifier = Modifier.padding(top = 8.dp, start = 15.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(3.dp)
                ) {
                    Text(
                        text = sellerProfile.nickname,
                        color = CarrotTheme.colors.gray8,
                        style = CarrotTheme.typography.body.b_18
                    )
                    Text(
                        text = "#5434272",
                        color = CarrotTheme.colors.gray6,
                        style = CarrotTheme.typography.caption.md_14_028,
                        modifier = Modifier.padding(top = 3.dp)
                    )
                }
                Text(
                    text = "5시간 전 접속",
                    color = CarrotTheme.colors.gray5,
                    style = CarrotTheme.typography.caption.md_12
                )
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(1f),
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            Row(
                modifier = Modifier
                    .background(
                        color = CarrotTheme.colors.gray2,
                        shape = RoundedCornerShape(4.dp)
                    )
                    .padding(vertical = 9.dp)
                    .weight(1f),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "매너 칭찬하기",
                    color = CarrotTheme.colors.gray8,
                    style = CarrotTheme.typography.body.bla_15_03
                )
            }

            Row(
                modifier = Modifier
                    .background(
                        color = CarrotTheme.colors.orange3,
                        shape = RoundedCornerShape(4.dp)
                    )
                    .padding(vertical = 9.dp)
                    .weight(1f)
                    .noRippleClickable { onFollowClick() },
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "팔로우",
                    color = CarrotTheme.colors.orange1,
                    style = CarrotTheme.typography.body.bla_15_03
                )
            }
        }

        Row(
            modifier = Modifier.padding(top = 25.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                text = "매너온도",
                color = CarrotTheme.colors.gray8,
                style = CarrotTheme.typography.caption.md_14_028,
                textDecoration = TextDecoration.Underline,
            )
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_help_24),
                contentDescription = null,
                tint = CarrotTheme.colors.gray8
            )
        }

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center
        ) {
            var boxWidth by remember { mutableIntStateOf(0) }
            var textWidth by remember { mutableIntStateOf(0) }

            val calculatedOffset by remember(boxWidth, textWidth) {
                derivedStateOf {
                    if (boxWidth > 0 && textWidth > 0) {
                        ((boxWidth * 0.365f - textWidth / 2f).toInt())
                    } else {
                        0
                    }
                }
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .onGloballyPositioned { coordinates ->
                        boxWidth = coordinates.size.width
                    }
            ) {
                Column(
                    modifier = Modifier
                        .offset {
                            IntOffset(
                                x = calculatedOffset,
                                y = 0
                            )
                        }
                        .padding(top = 2.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        modifier = Modifier.onGloballyPositioned { coordinates ->
                            textWidth = coordinates.size.width
                        },
                        text = "첫 온도 36.5℃",
                        color = CarrotTheme.colors.gray6,
                        style = CarrotTheme.typography.caption.md_12
                    )
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.ic_triangle_8),
                        contentDescription = "온도 표시 아이콘",
                        tint = CarrotTheme.colors.gray6
                    )
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "46.5℃",
                        color = CarrotTheme.colors.orange2,
                        style = CarrotTheme.typography.body.b_18_144
                    )
                    Image(
                        painter = painterResource(R.drawable.img_smile),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.padding(start = 3.dp)
                    )
                }
            }
        }

        Column(
            modifier = Modifier.padding(top = 4.dp)
        ) {
            val currentProgress by remember { mutableFloatStateOf(0.465f) }

            LinearProgressIndicator(
                progress = { currentProgress },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(10.dp),
                strokeCap = StrokeCap.Round,
                color = CarrotTheme.colors.orange2,
                trackColor = CarrotTheme.colors.gray4,
            )
        }

        Row(
            modifier = Modifier.padding(top = 26.dp),
            horizontalArrangement = Arrangement.spacedBy(53.dp),
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_like_sm_black_18),
                    contentDescription = null,
                    tint = CarrotTheme.colors.gray8
                )
                Column(
                    verticalArrangement = Arrangement.spacedBy(7.dp),
                ) {
                    Text(
                        text = buildAnnotatedString {
                            append("재거래 희망률 ")
                            withStyle(style = CarrotTheme.typography.body.sb_14.toSpanStyle()) {
                                append("100%")
                            }
                        },
                        color = CarrotTheme.colors.gray8,
                        style = CarrotTheme.typography.body.r_14
                    )
                    Text(
                        text = "124명 중 124명이 만족",
                        color = CarrotTheme.colors.gray6,
                        style = CarrotTheme.typography.body.md_13_18_013,
                    )
                }
            }
            Row(
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_chat_solo_18),
                    contentDescription = null,
                    tint = CarrotTheme.colors.gray8
                )
                Column(
                    verticalArrangement = Arrangement.spacedBy(7.dp)
                ) {
                    Text(
                        text = buildAnnotatedString {
                            append("응답률 ")
                            withStyle(style = CarrotTheme.typography.body.sb_14.toSpanStyle()) {
                                append("100%")
                            }
                        },
                        color = CarrotTheme.colors.gray8,
                        style = CarrotTheme.typography.body.r_14
                    )
                    Text(
                        text = "보통 10분 이내 응답",
                        color = CarrotTheme.colors.gray6,
                        style = CarrotTheme.typography.body.md_13_18_013,
                        modifier = Modifier.padding(end = 16.dp),
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewSellerProfileSection() {
    SellerProfileSection(
        onFollowClick = {},
        sellerProfile = UserDetail(
            userId = 1L,
            nickname = "asd",
            profileImage = "",
            address = ""
        )
    )
}
