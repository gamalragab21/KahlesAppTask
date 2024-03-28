package net.gamal.kahlesapptask

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import net.gamal.kahlesapptask.android.helpers.logging.LoggerFactory
import net.gamal.kahlesapptask.android.helpers.logging.writers.LogcatWriter

@HiltAndroidApp
class PostsApp : Application() {
    override fun onCreate() {
        super.onCreate()
        LoggerFactory.setLogWriter(LogcatWriter("PostsApp-v1", true))
    }
}