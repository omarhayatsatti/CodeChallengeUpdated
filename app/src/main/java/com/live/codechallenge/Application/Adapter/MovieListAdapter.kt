package com.live.codechallenge.Application.Adapter

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.live.codechallenge.Application.Models.Datum
import com.live.codechallenge.Application.Util.GlideImageLoader
import android.widget.Filter
import android.widget.Filterable
import com.live.codechallenge.R
import com.live.codechallenge.databinding.MovieRowBinding
import kotlinx.android.synthetic.main.movie_row.view.*


class MovieListAdapter: RecyclerView.Adapter<MovieListAdapter.MyViewHolder>, Filterable {
    private var movieList: ArrayList<Datum>? = null
    private var movieListFiltered: ArrayList<Datum>? = null
    private var context:Context?=null
    constructor(context:Context?,movieList: ArrayList<Datum>?){
        this.movieList = movieList
        this.movieListFiltered = movieList
        this.context =  context
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var layoutInflater = LayoutInflater.from(parent.context)
        var binding: MovieRowBinding = DataBindingUtil.inflate(layoutInflater, R.layout.movie_row, parent, false)
        return MyViewHolder(binding)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var list = this.movieListFiltered!![position]
        holder.binding!!.model = list
        list.setTitle(list!!.getTitle().toString())
        list.setYear(list!!.getYear().toString())
        GlideImageLoader.LoadImage(context,holder.binding!!.root.poster,R.drawable.ic_movie_placeholder,list!!.getPoster().toString())
    }


    override fun getItemCount(): Int {
        return movieListFiltered!!.size
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var binding: MovieRowBinding? = null

        constructor(binding: MovieRowBinding) : this(binding.root) {
            this.binding = binding
        }

    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(charSequence: CharSequence): Filter.FilterResults {
                val charString = charSequence.toString()
                if (charString.isEmpty()) {
                    movieListFiltered = movieList
                } else {
                    val filteredList = arrayListOf<Datum>()
                    for (movie in movieList!!) {
                        if (movie.getTitle()!!.toLowerCase().contains(charString.toLowerCase())|| movie.getGenre()!!.toLowerCase().contains(charString.toLowerCase())) {
                            filteredList.add(movie)
                        }
                    }
                    movieListFiltered = filteredList
                }

                val filterResults = Filter.FilterResults()
                filterResults.values = movieListFiltered
                return filterResults
            }

            override fun publishResults(charSequence: CharSequence, filterResults: Filter.FilterResults) {
                movieListFiltered = filterResults.values as ArrayList<Datum>

                notifyDataSetChanged()
            }
        }
    }


}