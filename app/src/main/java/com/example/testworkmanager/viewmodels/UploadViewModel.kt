package com.example.testworkmanager.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.io.File

class UploadViewModel: ViewModel() {

    val isCurrentPictureUploaded:MutableLiveData<Boolean> = MutableLiveData()

    init {
        isCurrentPictureUploaded.value = false
    }

    val currentPicture: MutableLiveData<File> = MutableLiveData()

    public fun uploadPicture():LiveData<Boolean> {

        //TODO WorkManager will
        return isCurrentPictureUploaded
    }
}