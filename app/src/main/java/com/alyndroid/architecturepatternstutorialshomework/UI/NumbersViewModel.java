package com.alyndroid.architecturepatternstutorialshomework.UI;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NumbersViewModel extends ViewModel {

    public MutableLiveData<Integer> liveData = new MutableLiveData<>();

    LiveData<Integer> getLiveData() {
        return liveData;
    }

    public void getNumbers(int num1, int num2){
        int result = num1 * num2;
        liveData.setValue(result);
    }
}
