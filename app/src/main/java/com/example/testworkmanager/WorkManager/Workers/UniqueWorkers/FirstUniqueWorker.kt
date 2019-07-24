package com.example.testworkmanager.WorkManager.Workers.UniqueWorkers

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.OneTimeWorkRequest
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkerParameters

class FirstUniqueWorker(context: Context, params: WorkerParameters) : CoroutineWorker(context, params) {

    val TAG = javaClass.simpleName

    override suspend fun doWork(): Result {
        Log.d(TAG, "First Unique Worker has been fired !")
        return Result.success()
    }

    companion object {
        fun getFirstUniqueWorkerBuilded(): OneTimeWorkRequest {
            return OneTimeWorkRequestBuilder<FirstUniqueWorker>()
                .build()
        }
    }
}