package com.eclipseprogrammer.takeawalk.ui.view;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import model.ViewRepository;


public class ViewViewModel extends ViewModel {



    private MutableLiveData<List<walk>> walk;
    private ViewRepository repository;

    public ViewViewModel() {
        repository = new ViewRepository();
    }

    public LiveData<List<walk>> getWalk() {
        return repository.getWalk();
    }
}