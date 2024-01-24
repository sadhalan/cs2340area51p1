package com.example.team51project1.ui.classes;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ClassesViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public ClassesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is classes fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}