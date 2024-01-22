package com.example.team51project1.ui.exams;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ExamsViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public ExamsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is exams fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}