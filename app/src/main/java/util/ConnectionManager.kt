package util

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

class ConnectionManager {
    fun checkConnectivity(context: Context):Boolean{
        //this gives us information about currently active network
    val connectivityManager=context.getSystemService(Context.CONNECTIVITY_SERVICE)as ConnectivityManager
        val activeNetwork:NetworkInfo?=connectivityManager.activeNetworkInfo
        if(activeNetwork?.isConnected!=null)
        {
            return activeNetwork.isConnected
        }
        else
        {
            return false
        }
    }
}