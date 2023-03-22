package com.example.rickandmortyimba.repositories.pagingsources

import android.net.Uri
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.rickandmortyimba.data.network.apiservices.EpisodeApiService
import com.example.rickandmortyimba.models.EpisodeModel
import retrofit2.HttpException
import java.io.IOException

private const val CHARACTER_STARTING_PAGE_INDEX = 1

class EpisodePagingSource (private val episodeApiService: EpisodeApiService)
    : PagingSource<Int, EpisodeModel>() {

    override fun getRefreshKey(state: PagingState<Int, EpisodeModel>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, EpisodeModel> {
        val position = params.key ?: CHARACTER_STARTING_PAGE_INDEX
        return try {
            val response = episodeApiService.fetchEpisodes(position)
            val next = response.info.next
            val nextPageNumber = if (next == null) {
                null
            } else
                Uri.parse(response.info.next).getQueryParameter("page")!!.toInt()
            LoadResult.Page(
                data = response.results, prevKey = null, nextKey = nextPageNumber
            )
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }
}