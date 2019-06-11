package mithou.moftak.com.mithuo.Api

import android.content.ContentValues.TAG
import android.util.Log
import com.live.codechallenge.Application.Models.MovieResponse
import com.live.codechallenge.Application.Util.CallBacks

import mithou.moftak.com.mithuo.Retrofit.ApiUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostRequest {

    private var mAPIService: APIService = ApiUtils.getAPIService()
    var endpoint: String? = null
    var callBacks: CallBacks? = null

    /**Constructor to initialize [CallBacks] and endpoint*/
    constructor(endpoint: String, callBacks: CallBacks) {
        this.endpoint = endpoint
        this.callBacks = callBacks
    }

    /*Call movie list*/
    fun movieList() {
        var call = mAPIService.getMoviesList()
        call.enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {

                if (response.isSuccessful) {
                    callBacks!!.onTaskCompleted(endpoint, response)
                    Log.i(TAG, "get movie list Success." + response.body().toString())
                } else {
                    callBacks!!.onTaskCompleted(endpoint, response)
                }
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                callBacks!!.onError(endpoint, t.toString())
            }
        })
    }


}