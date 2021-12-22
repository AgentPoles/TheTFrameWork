package com.mycompany.myapp.thetframework;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import java.util.List;

public class MySinglesViewModel extends ViewModel {
private LiveData<List<Info>> info;
private LiveData<List<Documents>> doc;
private LiveData<List<Folders>> folder;
private LiveData<List<User>> user;
private LiveData<question> question;
private LiveData<Answer> answer;

public MySinglesViewModel(AppDatabase database, int id){
        question = database.questionDao().LoadQuestionById(id);
        }

public LiveData<com.mycompany.myapp.thetframework.question> getQuestion() {
        return question;
        }
        }
