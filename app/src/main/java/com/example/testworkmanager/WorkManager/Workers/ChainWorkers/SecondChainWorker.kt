package com.example.testworkmanager.WorkManager.Workers.ChainWorkers

import android.content.Context
import android.util.Log
import androidx.work.*

class SecondChainWorker(context: Context, params : WorkerParameters): CoroutineWorker(context, params) {

    val TAG = javaClass.simpleName

    override suspend fun doWork(): Result {
        Log.d(TAG, "Second Chained Worker is OK !")
        return Result.success()
    }

    companion object {
        fun getSecondChainWorkerBuilded(): OneTimeWorkRequest {
            val constraints = Constraints.Builder()
                .setRequiredNetworkType(NetworkType.UNMETERED)

            return OneTimeWorkRequestBuilder<SecondChainWorker>()
                .build()
        }
    }
}