package com.zj.composedouban.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.google.accompanist.coil.rememberCoilPainter
import com.google.accompanist.insets.statusBarsHeight
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun HomeScreen() {
    Column(Modifier) {
        rememberSystemUiController().setStatusBarColor(Color.Transparent, darkIcons = true)
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .statusBarsHeight()
        )
        Text(
            text = "电影榜单",
            color = Color.Black,
            style = MaterialTheme.typography.h5,
            modifier = Modifier.padding(16.dp, 16.dp, 16.dp, 8.dp)
        )
        LazyRow {
            items(3) {
                TopRankItem()
            }
        }
    }
}

@Composable
fun TopRankItem() {
    Box(
        modifier = Modifier
            .size(180.dp, 220.dp)
            .padding(8.dp)
            .clip(RoundedCornerShape(10.dp))
    ) {
        Image(
            painter = rememberCoilPainter(request = "https://img2.doubanio.com/view/photo/s_ratio_poster/public/p480747492.jpg"),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(Color(0xFF7F6351), Color(0x807F6351)),
                        start = Offset(0f, Float.POSITIVE_INFINITY),
                        end = Offset(Float.POSITIVE_INFINITY, 0f)
                    )
                )
                .padding(8.dp)

        ) {
            Text(
                text = "一周口碑电影榜",
                color = Color.White,
                style = MaterialTheme.typography.subtitle1
            )
            Text(text = "豆瓣电影", color = Color.White, style = MaterialTheme.typography.overline)

            Text(
                text = "1 新.福音战士剧场版:终",
                color = Color.White,
                style = MaterialTheme.typography.overline,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.padding(0.dp, 60.dp, 0.dp, 0.dp)
            )
            Text(
                text = "9.3分",
                color = Color(0xffffac2d),
                style = MaterialTheme.typography.overline,
                modifier = Modifier.padding(12.dp, 0.dp, 0.dp, 2.dp)
            )
            Text(
                text = "2 再见了所有福音战士,再见了所有福音战士,再见了所有福音战士",
                color = Color.White,
                style = MaterialTheme.typography.overline,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = "9.2分",
                color = Color(0xffffac2d),
                style = MaterialTheme.typography.overline,
                modifier = Modifier.padding(12.dp, 0.dp, 0.dp, 2.dp)
            )
            Text(
                text = "3 健听女孩",
                color = Color.White,
                style = MaterialTheme.typography.overline,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = "8.3分",
                color = Color(0xffffac2d),
                style = MaterialTheme.typography.overline,
                modifier = Modifier.padding(12.dp, 0.dp, 0.dp, 2.dp)
            )
        }
    }
}