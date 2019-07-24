package com.example.testworkmanager.WorkManager.Workers.MiscWorkers

import android.content.Context
import androidx.work.*

class inputWorker(context: Context, params: WorkerParameters): CoroutineWorker(context, params) {

    override suspend fun doWork(): Result {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    companion object {
        fun getInputWorkerBuilded(): OneTimeWorkRequest {
            return OneTimeWorkRequestBuilder<inputWorker>()
                .build()
        }
    }
}