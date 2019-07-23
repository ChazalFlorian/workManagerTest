package com.example.testworkmanager.WorkManager.Workers.ChainWorkers

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters

class SecondChainWorker(context: Context, params : WorkerParameters): CoroutineWorker(context, params) {

    val TAG = javaClass.simpleName

    override suspend fun doWork(): Result {
        Log.d(TAG, "Second Chained Worker is OK !")
        return Result.success()
    }
}