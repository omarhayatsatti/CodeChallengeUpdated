package com.live.codechallenge.Application.Movies

import android.content.Context
import android.support.v7.widget.RecyclerView
import com.live.codechallenge.Application.Adapter.MovieListAdapter
import com.live.codechallenge.Application.Models.Datum

interface MovieContract {
    interface MovieView{
        fun getRecylerViewObj():RecyclerView?
        fun getContextObj():Context?
        fun showProgressBar()
        fun hideProgressBar()

    }
    interface MoviePresenter{
        fun setMoviesList(movieList:ArrayList<Datum>?)
        fun getMovieList()
        fun getMovieAdapter(): MovieListAdapter

    }
}