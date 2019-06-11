package com.live.codechallenge.Application.Movies

import android.widget.Toast
import com.google.gson.GsonBuilder
import com.live.codechallenge.Application.Adapter.MovieListAdapter
import com.live.codechallenge.Application.Models.Datum
import com.live.codechallenge.Application.Models.MovieResponse
import com.live.codechallenge.Application.Util.CallBacks
import mithou.moftak.com.mithuo.Api.PostRequest
import retrofit2.Response
import java.lang.Exception

class MoviePresenter:MovieContract.MoviePresenter,CallBacks {
    private var movieAdapter: MovieListAdapter? = null



    private var movieView:MovieContract.MovieView?=null
    private var postRequest:PostRequest?=null
    constructor(movieView:MovieContract.MovieView){
        this.movieView = movieView
        postRequest= PostRequest("getMovieList",this)
        getMovieList()
    }
    override fun setMoviesList(movieList:ArrayList<Datum>?) {
        movieAdapter = MovieListAdapter(movieView!!.getContextObj(),movieList)
        movieView!!.getRecylerViewObj()!!.adapter = movieAdapter
    }

    override fun onTaskCompleted(endpoint: String?, response: Response<*>?) {
        try {
            movieView!!.hideProgressBar()
            if (response != null) {
                var movieResponse: MovieResponse? = null
                if (response!!.code() == 400) {
                    val gson = GsonBuilder().create()
                    movieResponse = gson.fromJson(response.errorBody().string(), MovieResponse::class.java)
                    setMoviesList(movieResponse!!.getData() as ArrayList)

                } else {
                    movieResponse = response.body() as MovieResponse

                    setMoviesList(movieResponse!!.getData() as ArrayList)

                }

            }
        }catch (e:Exception){
            Toast.makeText(movieView!!.getContextObj(),"Something went wrong",Toast.LENGTH_LONG).show()
            e.printStackTrace()
        }
    }

    override fun onError(endpoint: String?, error: String) {
        movieView!!.showProgressBar()
        Toast.makeText(movieView!!.getContextObj(),error,Toast.LENGTH_LONG).show()
    }
    override fun getMovieList() {
        movieView!!.showProgressBar()
        postRequest!!.movieList()

    }
    override fun getMovieAdapter():MovieListAdapter {
        return movieAdapter!!
    }
}