package com.example.testworkmanager.WorkManager

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.work.ExistingWorkPolicy
import androidx.work.WorkInfo
import androidx.work.WorkManager
import com.example.testworkmanager.WorkManager.Workers.ChainWorkers.FirstChainWorker
import com.example.testworkmanager.WorkManager.Workers.ChainWorkers.SecondChainWorker
import com.example.testworkmanager.WorkManager.Workers.ChainWorkers.ThirdChainWorker
import com.example.testworkmanager.WorkManager.Workers.UniqueWorkers.FirstUniqueWorker
import com.example.testworkmanager.WorkManager.Workers.RecurrentWorker
import com.example.testworkmanager.WorkManager.Workers.WifiSyncWorker

class WorkSynchronizer(context: Context) {

    val workManager: WorkManager = WorkManager.getInstance(context)

    val firstUniqueWorkState: MutableLiveData<WorkInfo.State> = MutableLiveData()
    val secondUniqueWorkState: MutableLiveData<WorkInfo.State> = MutableLiveData()

    init {
        //simple worker
        workManager.enqueue(WifiSyncWorker.getWifiSyncWorkerBuilded())

        //chained Workers: first three parrallel ones, then the Wifi ones ONCE AND ONLY ONCE the first ones are successful
        workManager
            .beginWith(
                listOf(
                    FirstChainWorker.getFirstChainWorkerBuilded(),
                    SecondChainWorker.getSecondChainWorkerBuilded(),
                    ThirdChainWorker.getThirdChainWorkerBuilded()
                )
            )
            .then(WifiSyncWorker.getWifiSyncWorkerBuilded())
            .enqueue()

        //Workers fired every 15MIN
        workManager.enqueue(RecurrentWorker.getRecurrentWorkerBuilded())

        //testing unique Workers
        workManager.enqueueUniqueWork("syncExample", ExistingWorkPolicy.KEEP, FirstUniqueWorker.getFirstUniqueWorkerBuilded())
        workManager.enqueueUniqueWork("syncExample", ExistingWorkPolicy.REPLACE, SecondChainWorker.getSecondChainWorkerBuilded())
    }
}