package com.zj.composedouban.viewmodel

import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.zj.composedouban.data.HomeTypeRankItem
import com.zj.composedouban.data.RankDetail
import com.zj.composedouban.viewmodel.paged.MovieSource
import kotlinx.coroutines.flow.Flow

class RankViewModel : ViewModel() {
    val rankItems: Flow<PagingData<RankDetail>> =
        Pager(PagingConfig(pageSize = 10, prefetchDistance = 1)) {
            MovieSource()
        }.flow
}