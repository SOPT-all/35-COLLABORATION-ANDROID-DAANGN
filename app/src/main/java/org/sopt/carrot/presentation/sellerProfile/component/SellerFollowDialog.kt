package org.sopt.carrot.presentation.sellerProfile.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import org.sopt.carrot.core.extension.noRippleClickable
import org.sopt.carrot.ui.theme.CarrotTheme

@Composable
fun SellerFollowDialog(
    onClickCancel: () -> Unit
) {
    Dialog(
        onDismissRequest = onClickCancel,
        properties = DialogProperties(
            dismissOnBackPress = true,
            dismissOnClickOutside = true,
        )
    ) {
        Card(
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(CarrotTheme.colors.white)
        ) {
            Column(
                modifier = Modifier.padding(20.dp)
            ) {
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = "팔로우한 '헿헿'님의",
                    color = CarrotTheme.colors.gray8,
                    style = CarrotTheme.typography.title.b_20_04
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "매물소식을 가장 먼저 받아보세요!",
                    color = CarrotTheme.colors.gray8,
                    style = CarrotTheme.typography.title.b_20_04
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "새로운 상품이 올라올 때마다",
                    color = CarrotTheme.colors.gray5,
                    style = CarrotTheme.typography.body.md_16_07
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = "알려드릴게요.",
                    color = CarrotTheme.colors.gray5,
                    style = CarrotTheme.typography.body.md_16_07
                )

                Row(
                    modifier = Modifier
                        .padding(top = 28.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .background(
                                color = CarrotTheme.colors.gray2,
                                shape = RoundedCornerShape(6.dp)
                            )
                            .padding(vertical = 15.dp)
                            .weight(1f)
                            .noRippleClickable { onClickCancel() },
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "닫기",
                            color = CarrotTheme.colors.gray8,
                            style = CarrotTheme.typography.body.extb_15
                        )
                    }

                    Row(
                        modifier = Modifier
                            .background(
                                color = CarrotTheme.colors.orange1,
                                shape = RoundedCornerShape(6.dp)
                            )
                            .padding(vertical = 15.dp, horizontal = 45.dp),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "알림받기",
                            color = CarrotTheme.colors.white,
                            style = CarrotTheme.typography.body.extb_15
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewSellerFollowDialog() {
    SellerFollowDialog(
        onClickCancel = {}
    )
}
