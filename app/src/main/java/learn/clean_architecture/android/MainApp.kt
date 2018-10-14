package learn.clean_architecture.android

import android.app.Application
import learn.clean_architecture.android.koin.appModule
import org.koin.android.ext.android.startKoin

/**
 * Created by Yoga C. Pranata on 14/10/2018.
 * Android Engineer
 */
class MainApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(appModule))
    }
}