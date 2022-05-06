package com.islam.demo.singlelivedata;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.islam.singlelivedata.SingleLiveData;

public class MainViewModel extends ViewModel {

    private final SingleLiveData<String> singleLiveData = new SingleLiveData<>();
    private final MutableLiveData<String> normalLiveData = new MutableLiveData<>();

    public void RequestSingleLiveData() {
        singleLiveData.setValue("Single Live Data Received");
    }

    public void RequestNormalLiveData() {
        normalLiveData.setValue("Normal Live Data Received");
    }

    public SingleLiveData<String> getSingleLiveData() {
        return singleLiveData;
    }

    public LiveData<String> getNormalLiveData() {
        return normalLiveData;
    }
}