package com.example.mytravelguide.utilities

import android.util.Log
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.lang.Exception
import java.net.HttpURLConnection
import java.net.URL


class DownloadUrl {
    fun readUrl(strUrl: String): String {
        var data = ""
        var isStream: InputStream? = null
        var urlConnection: HttpURLConnection? = null
        try {
            val url = URL(strUrl)
            //creating http connection to communicate with url
            urlConnection = url.openConnection() as HttpURLConnection
            isStream = urlConnection.inputStream
            val br = BufferedReader(InputStreamReader(isStream))
            val sb = StringBuffer()
            val line= ""
            while ((br.readLine()) != null) {
                sb.append(line)
            }
            data = sb.toString()
            Log.d("downloadUrl", data)
            br.close()
        } catch (e: Exception) {
            Log.d("Exception", e.toString())
        } finally {
            isStream?.close()
            urlConnection?.disconnect()
        }
        return data
    }
}