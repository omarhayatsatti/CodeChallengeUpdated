package com.live.codechallenge.Application.Util

import android.app.Application


class Config : Application() {



    companion object {
        var config: Config? = null
        fun getInstance(): Config {
            if (config == null) { //if there is no instance available... create new one
                config = Config()
            }

            return config as Config
        }
    }

}