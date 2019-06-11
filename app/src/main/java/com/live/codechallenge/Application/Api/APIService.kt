package mithou.moftak.com.mithuo.Api

import com.live.codechallenge.Application.Models.MovieResponse
import retrofit2.Call
import retrofit2.http.*

interface APIService {
    /*get movies list*/
    @GET("/api/movies")
    fun getMoviesList(): Call<MovieResponse>
}