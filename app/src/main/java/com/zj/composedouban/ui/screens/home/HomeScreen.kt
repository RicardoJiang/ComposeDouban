package com.zj.composedouban.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
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
import com.zj.composedouban.util.noRippleClickable

@Composable
fun HomeScreen() {
    Column(Modifier) {
        rememberSystemUiController().setStatusBarColor(Color.Transparent, darkIcons = true)
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .statusBarsHeight()
        )
        TopRank()
        YearRank()
    }
}

@Composable
fun TopRank() {
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

@Composable
fun YearRank() {
    Text(
        text = "年度电影榜单",
        color = Color.Black,
        style = MaterialTheme.typography.h5,
        modifier = Modifier.padding(16.dp, 8.dp)
    )
    var selectIdx by remember { mutableStateOf(0) }
    val list = listOf("2020", "2019", "2018", "2017", "2016", "2015", "2014")
    YearRow(list = list, selectIdx = selectIdx) {
        selectIdx = it
    }
    YearRankItems(list[selectIdx])
}

@Composable
fun YearRow(list: List<String>, selectIdx: Int, onSelectChange: (Int) -> Unit) {
    LazyRow(contentPadding = PaddingValues(4.dp, 8.dp, 8.dp, 0.dp)) {
        itemsIndexed(list) { index, it ->
            val backgroundColor = if (index == selectIdx) 0xFFE0F7E8 else 0xFFF6F6F6
            val contentColor = if (index == selectIdx) 0xFF008E00 else 0xFF000000
            Text(
                text = it,
                color = Color(contentColor),
                style = MaterialTheme.typography.body2,
                modifier = Modifier
                    .padding(8.dp, 0.dp, 0.dp, 0.dp)
                    .clip(RoundedCornerShape(5.dp))
                    .background(Color(backgroundColor))
                    .padding(7.dp, 4.dp)
                    .noRippleClickable {
                        onSelectChange.invoke(index)
                    }
            )
        }
    }
}

@Composable
fun YearRankItems(year: String) {
    val titleList = listOf("华语电影", "外语电影", "冷门佳片")
    val colorList = listOf(0xff442526, 0xff424243, 0xff442C2F)
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp, 16.dp, 0.dp, 0.dp)
    ) {
        for (i in titleList.indices) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(120.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color(colorList[i]))
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "${year}高分榜",
                        color = Color.White,
                        style = MaterialTheme.typography.body1
                    )
                    Text(
                        text = titleList[i],
                        color = Color.White,
                        style = MaterialTheme.typography.h5
                    )
                }
            }
        }
    }
}
