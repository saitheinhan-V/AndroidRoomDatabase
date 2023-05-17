package com.my.room;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.my.room.dao.WordDao;
import com.my.room.database.WordRoomDatabase;
import com.my.room.model.Word;

import java.util.List;

public class BaseRepository {

    private final WordDao wordDao;
    public LiveData<List<Word>> wordList;

    public BaseRepository(Application application){
        WordRoomDatabase db = WordRoomDatabase.getDatabase(application);
        wordDao = db.wordDao();
        wordList = wordDao.getWordByAlphabet();
    }

    LiveData<List<Word>> getAllWords(){
        return wordList;
    }

    public void insert(Word word){
        WordRoomDatabase.databaseWriteExecutor.execute(()->{
            wordDao.insertWord(word);
        });
    }
}
