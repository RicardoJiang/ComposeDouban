package com.zj.composedouban.viewmodel.paged

import androidx.paging.PagingSource
import androidx.paging.PagingState

import com.zj.composedouban.data.HomeTypeRankItem
import com.zj.composedouban.data.homeTypeRankList

class MovieSource : PagingSource<Int, HomeTypeRankItem>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, HomeTypeRankItem> {
        return try {
            val nextPage = params.key ?: 1
            val movieListResponse = homeTypeRankList

            LoadResult.Page(
                data = movieListResponse,
                prevKey = if (nextPage == 1) null else nextPage - 1,
                nextKey = nextPage + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, HomeTypeRankItem>): Int {
        return 0
    }
}