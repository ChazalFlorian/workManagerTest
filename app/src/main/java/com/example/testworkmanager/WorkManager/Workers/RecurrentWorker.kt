package com.example.testworkmanager.WorkManager.Workers

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.PeriodicWorkRequest
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkerParameters
import java.util.concurrent.TimeUnit

class RecurrentWorker(context: Context, params: WorkerParameters) : CoroutineWorker(context, params) {

    val TAG = javaClass.simpleName

    var secondCount = 0

    override suspend fun doWork(): Result {
        secondCount += 1
        Log.d(TAG, "Recurrent Worker finished ! launched $secondCount times.")
        return Result.success()
    }

    companion object {
        fun getRecurrentWorkerBuilded(): PeriodicWorkRequest {
            return PeriodicWorkRequestBuilder<RecurrentWorker>(15, TimeUnit.MINUTES)
                .build()
        }
    }
}