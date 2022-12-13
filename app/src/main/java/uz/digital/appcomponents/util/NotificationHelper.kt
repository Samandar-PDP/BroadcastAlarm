package uz.digital.appcomponents.util

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import uz.digital.appcomponents.R

class NotificationHelper(
    private val context: Context
) {
    private lateinit var manager: NotificationManager
    private val channelId = "my_channel_id"

    init {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createNotification()
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun createNotification() {
        val channel = NotificationChannel(
            channelId,
            "MyNotification",
            NotificationManager.IMPORTANCE_HIGH
        )
        getManager().createNotificationChannel(channel)
    }

    fun getManager(): NotificationManager {
        if (!::manager.isInitialized) {
            manager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        }
        return manager
    }
    fun getChannelNotification(): NotificationCompat.Builder {
        return NotificationCompat.Builder(context, channelId)
            .setContentTitle("This is alarm manager")
            .setContentText("Your alarm is working")
            .setSmallIcon(R.drawable.ic_baseline_access_alarm_24)
    }
}