package uz.digital.appcomponents.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import uz.digital.appcomponents.NoInternetActivity
import uz.digital.appcomponents.util.NetworkUtils

class MyBroadcastReceiver: BroadcastReceiver() {
    private val TAG = "MyBroadcastReceiver"
    override fun onReceive(context: Context?, intent: Intent?) {
        if (!hasInternet(context!!)) {
            Toast.makeText(context, "No internet available", Toast.LENGTH_SHORT).show()
            context.startActivity(Intent(context, NoInternetActivity::class.java))
        }
    }
    private fun hasInternet(context: Context): Boolean {
        val networkUtils = NetworkUtils(context)
        return networkUtils.isNetworkConnected()
    }
}