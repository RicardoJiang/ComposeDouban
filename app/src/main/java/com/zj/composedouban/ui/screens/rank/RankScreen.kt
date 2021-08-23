package com.zj.composedouban.ui.screens.rank

import android.app.Activity
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.google.accompanist.insets.statusBarsHeight
import com.zj.composedouban.R

@Composable
fun RankScreen() {
    val scrollState = rememberLazyListState()
    Box {
        LazyColumn(state = scrollState) {
            item {
                RankTopItem()
            }
            val list = (1..16).toList().map { it.toString() }
            items(list) {
                RankListItem()
            }
        }
        RankHeader(scrollState)
    }
}

@Composable
fun RankHeader(scrollState: LazyListState) {
    val target = LocalDensity.current.run {
        200.dp.toPx()
    }
    val scrollPercent: Float = if (scrollState.firstVisibleItemIndex > 0) {
        1f
    } else {
        scrollState.firstVisibleItemScrollOffset / target
    }
    Log.i("tiaoshi", "here:" + scrollState.firstVisibleItemIndex)
    val activity = LocalContext.current as Activity
    val backgroundColor = Color(0xFF2E2E36)
    Column() {
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .statusBarsHeight()
                .alpha(scrollPercent)
                .background(backgroundColor)
        )
        Box(modifier = Modifier.height(44.dp)) {
            Spacer(
                modifier = Modifier
                    .fillMaxSize()
                    .alpha(scrollPercent)
                    .background(backgroundColor)
            )
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = R.mipmap.icon_back),
                    contentDescription = "back",
                    modifier = Modifier
                        .size(52.dp, 44.dp)
                        .padding(16.dp, 12.dp, 8.dp, 12.dp)
                        .clickable {
                            activity.finish()
                        }
                )
                Text(
                    text = "豆瓣电影 Top250",
                    color = Color.White,
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier.alpha(scrollPercent)
                )
            }

        }
    }
}

@Composable
fun RankTopItem() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
            .background(Color(0xFF2E2E36))
    ) {
        Spacer(modifier = Modifier.statusBarsHeight())
        Spacer(modifier = Modifier.height(64.dp))
        Text(
            text = "豆瓣电影 Top250",
            color = Color.White,
            style = MaterialTheme.typography.h5,
            modifier = Modifier.padding(16.dp, 8.dp)
        )
        Text(
            text = "250部 • 82.4万人关注",
            color = Color.White,
            style = MaterialTheme.typography.body2,
            modifier = Modifier.padding(16.dp, 0.dp)
        )
    }
}

@Composable
fun RankListItem() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .height(100.dp)
            .background(Color.Blue)
    ) {

    }
}