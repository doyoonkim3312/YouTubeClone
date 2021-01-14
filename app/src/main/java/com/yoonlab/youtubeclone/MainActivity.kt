package com.yoonlab.youtubeclone

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private val retrofit = Retrofit.Builder()
        .baseUrl("https://www.googleapis.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.testBtn).setOnClickListener {
            startRetrofitConnection(retrofit, this)
        }

    }

    fun callRetrofitService(retrofit: Retrofit) : YouTubeDataSearch {
        //initializing retrofit service.
        return retrofit.create(YouTubeDataSearch::class.java)
    }

    fun startRetrofitConnection(retrofit: Retrofit, context: Context) {

        val retrofitCall = callRetrofitService(retrofit).getSearchResult(
                "snippet", "itsub"
        )
        retrofitCall.enqueue(object: retrofit2.Callback<YouTubeSearch>{
            override fun onResponse(call: Call<YouTubeSearch>, response: Response<YouTubeSearch>) {
                if (response.isSuccessful) {
                    //findViewById<TextView>(R.id.testResultView).text = "API CONNECTION SUCCESSFUL"
                    Log.d("Api connection success!", response.body().toString())
                }
            }

            override fun onFailure(call: Call<YouTubeSearch>, t: Throwable) {
                //findViewById<TextView>(R.id.testResultView).text = "API CONNECTION FAILD"
                Log.d("api connection faild", t.message.toString())
            }

        })
    }
}