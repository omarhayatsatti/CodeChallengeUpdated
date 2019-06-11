package com.live.codechallenge.Application.Util

import retrofit2.Response

interface CallBacks {
    fun onTaskCompleted(endpoint: String?,response: Response<*>?)
    fun onError(endpoint: String?,error:String)
}