package org.sopt.carrot.presentation.productDetailScreen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.sopt.carrot.R
import org.sopt.carrot.presentation.productDetailScreen.model.UiProductInfoDto
import org.sopt.carrot.ui.theme.CarrotTheme

@Composable
fun ProductInfoSection(
    productInfo: UiProductInfoDto,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        HorizontalDivider(thickness = 1.dp, color = CarrotTheme.colors.gray3)
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = productInfo.title,
                style = CarrotTheme.typography.title.b_22_044,
                color = CarrotTheme.colors.gray8
            )

            Text(
                text = buildAnnotatedString {
                    withStyle(
                        SpanStyle(textDecoration = TextDecoration.Underline)
                    ) {
                        append(productInfo.category)
                    }
                    append(" . ")  // 밑줄 없는 부분
                    withStyle(
                        SpanStyle(textDecoration = TextDecoration.Underline)
                    ) {
                        append("끌올 ${productInfo.view}시간 전")
                    }
                },
                style = CarrotTheme.typography.caption.md_14_028,
                color = CarrotTheme.colors.gray5
            )
        }

        Text(
            text = productInfo.content,
            style = CarrotTheme.typography.body.md_17_017,
            color = CarrotTheme.colors.gray8
        )

        Column(
            verticalArrangement = Arrangement.spacedBy(28.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(2.dp)
            ) {
                Text(
                    text = buildAnnotatedString {
                        pushStyle(SpanStyle(textDecoration = TextDecoration.Underline))
                        append("관심 ${productInfo.view}")
                        pop()

                        append(" · ")

                        pushStyle(SpanStyle(textDecoration = TextDecoration.Underline))
                        append("조회 ${productInfo.view}")
                        pop()
                    },
                    style = CarrotTheme.typography.caption.md_14_028,
                    color = CarrotTheme.colors.gray5
                )
            }
            Text(
                text = stringResource(R.string.report_post),
                style = CarrotTheme.typography.body.md_15_05,
                color = CarrotTheme.colors.gray6
            )
        }
        HorizontalDivider(thickness = 1.dp, color = CarrotTheme.colors.gray3)
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductInfoSectionPreview() {

    ProductInfoSection(
        productInfo = UiProductInfoDto(
            title = "앤유 하프집업 맨투맨",
            category = "의류",
            content = "5회미만 착용 세탁 후 보관중\n깔끔하고 핏도 예뻐요\n팔 안쪽에 연하게 얼룩 감안해서 가격 낮춤니다",
            price = "75,000",
            view = 5
        )
    )
}

