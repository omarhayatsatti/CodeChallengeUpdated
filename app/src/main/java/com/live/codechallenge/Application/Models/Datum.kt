package com.live.codechallenge.Application.Models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



class Datum {
    @SerializedName("id")
    @Expose
    private var id: Int = 0
    @SerializedName("title")
    @Expose
    private var title: String? = null
    @SerializedName("year")
    @Expose
    private var year: String? = null
    @SerializedName("genre")
    @Expose
    private var genre: String? = null
    @SerializedName("poster")
    @Expose
    private var poster: String? = null

    fun getId(): Int {
        return id
    }

    fun setId(id: Int) {
        this.id = id
    }

    fun getTitle(): String? {
        return title
    }

    fun setTitle(title: String) {
        this.title = title
    }

    fun getYear(): String? {
        return year
    }

    fun setYear(year: String) {
        this.year = year
    }

    fun getGenre(): String? {
        return genre
    }

    fun setGenre(genre: String) {
        this.genre = genre
    }

    fun getPoster(): String? {
        return poster
    }

    fun setPoster(poster: String) {
        this.poster = poster
    }
}