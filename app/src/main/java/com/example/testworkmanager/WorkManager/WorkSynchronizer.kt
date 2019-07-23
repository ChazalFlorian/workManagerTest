package com.example.testworkmanager.WorkManager

import android.content.Context
import androidx.work.WorkManager
import com.example.testworkmanager.WorkManager.Workers.WifiSyncWorker

class WorkSynchronizer(context: Context) {

        val workManager: WorkManager = WorkManager.getInstance(context)

        init {
            workManager.enqueue(WifiSyncWorker.getWifiSyncWorkerBuilded())
            workManager.beginWith(listOf())
        }
}