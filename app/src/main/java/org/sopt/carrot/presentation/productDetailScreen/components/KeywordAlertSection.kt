package org.sopt.carrot.presentation.productDetailScreen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.carrot.R
import org.sopt.carrot.ui.theme.CarrotTheme

@Composable
fun KeywordAlertSection(
    productTitle: String,
    modifier: Modifier = Modifier
) {
    val limitedTitle = if (productTitle.length > 10) {
        productTitle.substring(0, 10) + "..."
    } else productTitle

    Column(
        modifier = modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(28.dp)
    ) {
        HorizontalDivider(thickness = 1.dp, color = CarrotTheme.colors.gray3)
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier.weight(1f),
                text = buildAnnotatedString {
                    val fullText = stringResource(R.string.neighbor_notification, limitedTitle)
                    withStyle(style = CarrotTheme.typography.body.md_15_05.toSpanStyle()) {
                        append(fullText.substringBefore(limitedTitle))
                    }
                    withStyle(style = CarrotTheme.typography.body.extb_15.toSpanStyle()) {
                        append(limitedTitle)
                    }
                    withStyle(style = CarrotTheme.typography.body.md_15_05.toSpanStyle()) {
                        append(fullText.substringAfter(limitedTitle))
                    }
                }
            )
            Button(
                modifier = Modifier
                    .wrapContentWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = CarrotTheme.colors.gray2,
                    contentColor = CarrotTheme.colors.gray8
                ),
                shape = RoundedCornerShape(6.dp),
                contentPadding = PaddingValues(0.dp),
                onClick = { }
            ) {
                Row(
                    modifier = Modifier.padding(horizontal = 18.dp, vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.ic_notification_sm_12),
                        contentDescription = null,
                        modifier = Modifier.padding(end = 8.dp)
                    )
                    Text(
                        text = "키워드 알림 받기",
                        style = CarrotTheme.typography.body.b_14
                    )
                }
            }
        }
        HorizontalDivider(thickness = 1.dp, color = CarrotTheme.colors.gray3)
    }
}


@Preview(showBackground = true)
@Composable
private fun KeywordAlertSectionPreview() {
    KeywordAlertSection(productTitle = "렉토 멘투맨")
}
