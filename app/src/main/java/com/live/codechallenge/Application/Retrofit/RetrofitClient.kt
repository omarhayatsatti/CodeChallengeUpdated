package mithou.moftak.com.mithuo.Retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.google.gson.GsonBuilder

import okhttp3.OkHttpClient

import java.util.concurrent.TimeUnit


class RetrofitClient {

   /* companion object {
        private var retrofit:Retrofit?=null
        var gson = GsonBuilder()
                .setLenient()
                .create()!!
        private var logger: HttpLoggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        private val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(logger)
                .connectTimeout(2, TimeUnit.MINUTES)
                .writeTimeout(2, TimeUnit.MINUTES)
                .readTimeout(2, TimeUnit.MINUTES)
                .build()
        fun getClient(baseUrl:String): Retrofit? {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                        .baseUrl(baseUrl)
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .client(okHttpClient)
                        .build()
            }
            return retrofit
        }
    }*/

    companion object {
        private var retrofit:Retrofit?=null
        //private var fileLogger:HttpLoggingInterceptor?=null
        var gson = GsonBuilder()
                .setLenient()
                .create()!!
        /* @JvmStatic
        *//* private var fileLogger:HttpLoggingInterceptor.Logger=  HttpLoggingInterceptor.Logger(function = object : Logger(), (message: String) -> Unit {
            override fun invoke(message: String) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        })
*/
        //private var logger: HttpLoggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)


        private val okHttpClient = OkHttpClient.Builder()
                //.addInterceptor(fileLoggerInterceptor)
                .connectTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .build()
        fun getClient(baseUrl:String): Retrofit? {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                        .baseUrl(baseUrl)
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .client(okHttpClient)
                        .build()
            }
            return retrofit
        }
    }
}