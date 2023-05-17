package com.my.room.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.my.room.BaseRepository;
import com.my.room.model.Word;

import java.util.List;

public class WordViewModel extends AndroidViewModel {

    private BaseRepository repository;

    private LiveData<List<Word>> mAllWords;

    public WordViewModel(@NonNull Application application) {
        super(application);
        repository = new BaseRepository(application);
        mAllWords = repository.wordList;
    }

    public LiveData<List<Word>> getAllWords(){
        return mAllWords;
    }

    public void insert(Word word){
        repository.insert(word);
    }
}
