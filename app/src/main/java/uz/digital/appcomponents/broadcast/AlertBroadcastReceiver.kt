package uz.digital.appcomponents.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import uz.digital.appcomponents.util.NotificationHelper

class AlertBroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val notificationHelper = NotificationHelper(context!!)
        notificationHelper.getManager()
            .notify(1, notificationHelper.getChannelNotification().build())
    }
}