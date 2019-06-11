package mithou.moftak.com.mithuo.Retrofit

import mithou.moftak.com.mithuo.Api.APIService


class ApiUtils {

    companion object {
      //  private val BASE_URL:String =  "http://192.168.0.41:3001"
        //https://test-api.mithuo.com/
        private val BASE_URL:String="https://movies-sample.herokuapp.com"
        fun getAPIService(): APIService {
            return RetrofitClient.getClient(BASE_URL)!!.create(APIService::class.java)
        }
    }
}