package com.example.testworkmanager.WorkManager.Workers.ChainWorkers

import android.content.Context
import android.util.Log
import androidx.work.*
import com.example.testworkmanager.WorkManager.Workers.WifiSyncWorker

class FirstChainWorker(context: Context, params : WorkerParameters): CoroutineWorker(context, params) {

    val TAG = javaClass.simpleName

    override suspend fun doWork(): Result {
        Log.d(TAG, "First Chained Worker is OK !")
        return Result.success()
    }

    companion object {
        fun getFirstChainWorker(): OneTimeWorkRequest {
            val constraints = Constraints.Builder()
                .setRequiredNetworkType(NetworkType.UNMETERED)

            return OneTimeWorkRequestBuilder<FirstChainWorker>()
                .build()
        }
    }
}