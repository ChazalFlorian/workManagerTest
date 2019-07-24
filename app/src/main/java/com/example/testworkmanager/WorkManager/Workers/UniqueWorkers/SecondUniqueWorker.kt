package com.example.testworkmanager.WorkManager.Workers.UniqueWorkers

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.OneTimeWorkRequest
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkerParameters

class SecondUniqueWorker(context: Context, params: WorkerParameters) : CoroutineWorker(context, params) {

    val TAG = javaClass.simpleName

    override suspend fun doWork(): Result {
        Log.d(TAG, "Second Worker has been fired !")
        return Result.success()
    }

    companion object {
        fun getSecondUniqueWorkerBuilded(): OneTimeWorkRequest {
            return OneTimeWorkRequestBuilder<SecondUniqueWorker>()
                .build()
        }
    }
}