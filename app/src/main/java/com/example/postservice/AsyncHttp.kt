package com.example.postservice

import android.os.AsyncTask
import android.support.annotation.IntegerRes
import android.util.Log
import java.io.IOException
import java.io.OutputStream
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL
import kotlin.properties.Delegates

class AsyncHttp( var name: String,  var value: Double) : AsyncTask<String, Int, Boolean>() {

     var urlConnection: HttpURLConnection by Delegates.notNull<HttpURLConnection>()
     var flg: Boolean = false


    override fun doInBackground(vararg contents: String?): Boolean {
        val urlinput = "http://10.206.0.104/upload/post.php"
        try {

            var url = URL(urlinput)
            urlConnection = url.openConnection() as HttpURLConnection
            urlConnection.requestMethod = "POST"
            urlConnection.doOutput = true


            var postDataSample: String = "name=" + name + "&text=" + value
            var out : OutputStream = urlConnection.outputStream
            out.write(postDataSample.toByteArray())
            out.flush()
            out.close()
            Log.d("test", postDataSample)
            urlConnection.inputStream
            flg = true
        } catch (e: MalformedURLException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }

        return flg
    }
}
