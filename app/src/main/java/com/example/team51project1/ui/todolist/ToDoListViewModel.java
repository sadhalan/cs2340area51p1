package com.example.team51project1.ui.todolist;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ToDoListViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public ToDoListViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("To-Do List");
    }

    public LiveData<String> getText() {
        return mText;
    }
}