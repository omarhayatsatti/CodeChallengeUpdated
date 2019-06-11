package com.live.codechallenge.Application.Movies

import android.content.Context
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import com.live.codechallenge.databinding.MovieActivityBinding
import android.support.v7.widget.GridLayoutManager
import kotlinx.android.synthetic.main.movie_activity.*


import android.app.SearchManager

import android.support.v7.widget.SearchView
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.live.codechallenge.R


class MovieView:AppCompatActivity(),MovieContract.MovieView {


    private var searchView: SearchView? = null
    private var binding: MovieActivityBinding? = null
    private var moviePresenter:MovieContract.MoviePresenter?=null
    private var mLayoutManager: RecyclerView.LayoutManager? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.movie_activity)
        mLayoutManager = GridLayoutManager(this, 3)
        recycler_view!!.layoutManager = mLayoutManager
        moviePresenter = MoviePresenter(this)
        binding!!.presenter = moviePresenter as MoviePresenter
    }

    override fun getRecylerViewObj(): RecyclerView? {
        return recycler_view
    }
    override fun getContextObj(): Context? {
        return this
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)

        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        searchView = menu.findItem(R.id.action_search)
            .actionView as SearchView
        searchView!!.setSearchableInfo(
            searchManager
                .getSearchableInfo(componentName)
        )
        searchView!!.maxWidth = Integer.MAX_VALUE

        searchView!!.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                moviePresenter!!.getMovieAdapter().filter.filter(query)
                return false
            }

            override fun onQueryTextChange(query: String): Boolean {
                moviePresenter!!.getMovieAdapter().filter.filter(query)
                return false
            }
        })
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        return if (id == R.id.action_search) {
            true
        } else super.onOptionsItemSelected(item)

    }
    override fun showProgressBar() {
       recycler_view.visibility = View.GONE
       progressBar.visibility = View.VISIBLE
    }

    override fun hideProgressBar() {
        recycler_view.visibility = View.VISIBLE
        progressBar.visibility = View.GONE
    }

}