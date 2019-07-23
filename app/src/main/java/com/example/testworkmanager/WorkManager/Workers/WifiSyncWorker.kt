package com.example.testworkmanager.WorkManager.Workers

import android.content.Context
import android.content.Context.CONNECTIVITY_SERVICE
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.util.Log
import androidx.work.*

class WifiSyncWorker(context: Context, params: WorkerParameters): CoroutineWorker(context, params ) {

    val TAG = javaClass.simpleName

    override suspend fun doWork(): Result {
        //Do the Work here
        Log.d(TAG, "Wifi has been conected ! Sync will start now...")
        return Result.success()
    }

    private fun checkStatus() {
        val manager: ConnectivityManager = applicationContext.getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager

        val is3G = manager.getNetworkCapabilities(manager.activeNetwork).hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)
    }

    companion object {
        fun getWifiSyncWorkerBuilded(): OneTimeWorkRequest {
            val constraints = Constraints.Builder()
                .setRequiredNetworkType(NetworkType.UNMETERED)

            return OneTimeWorkRequestBuilder<WifiSyncWorker>()
                .build()
        }
    }
}