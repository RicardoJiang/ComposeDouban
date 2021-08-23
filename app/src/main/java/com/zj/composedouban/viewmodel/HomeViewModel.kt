package com.zj.composedouban.viewmodel

import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.zj.composedouban.data.HomeTypeRankItem
import com.zj.composedouban.viewmodel.paged.MovieSource
import kotlinx.coroutines.flow.Flow

class HomeViewModel : ViewModel() {
    val typeRankItems: Flow<PagingData<HomeTypeRankItem>> = Pager(PagingConfig(pageSize = 10)) {
        MovieSource()
    }.flow
}