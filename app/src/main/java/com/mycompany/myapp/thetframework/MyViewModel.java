package com.mycompany.myapp.thetframework;
import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

public class MyViewModel extends AndroidViewModel {
    private LiveData<List<Info>> info;
    private LiveData<List<Documents>> doc;
    private LiveData<List<Folders>> folder;
    private LiveData<List<User>> user;
    private LiveData<List<question>> questions;
    private LiveData<List<Answer>> answers;
    private LiveData<List<Classors>> classors;
    public MyViewModel(@NonNull Application application) {
        super(application);
        AppDatabase appDatabase = AppDatabase.getsInstance(getApplication());
        info = appDatabase.infoDao().LoadAllInfo();
        folder = appDatabase.folderDao().LoadAllFolders();
        doc = appDatabase.docDao().LoadAllDocs();
        user = appDatabase.userDao().LoadAllUsers();
        questions = appDatabase.questionDao().LoadAllQuestions();
        answers = appDatabase.answerdao().LoadAllAnswer();
        classors = appDatabase.classorsDao().LoadAllClasses();

    }

    public LiveData<List<Info>> getInfo() {
        return info;
    }

    public LiveData<List<Documents>> getDoc() {
        return doc;
    }

    public LiveData<List<Folders>> getFolder() {
        return folder;
    }

    public void setDoc(LiveData<List<Documents>> doc) {
        this.doc = doc;
    }

    public void setFolder(LiveData<List<Folders>> folder) {
        this.folder = folder;
    }

    public void setInfo(LiveData<List<Info>> info) {
        this.info = info;
    }

    public LiveData<List<User>> getUser() {
        return user;
    }

    public void setUser(LiveData<List<User>> user) {
        this.user = user;
    }

    public LiveData<List<question>> getQuestions() {
        return questions;
    }

    public void setQuestions(LiveData<List<question>> questions) {
        this.questions = questions;
    }

    public void setAnswers(LiveData<List<Answer>> answers) {
        this.answers = answers;
    }

    public LiveData<List<Answer>> getAnswers() {
        return answers;
    }

    public void setClassors(LiveData<List<Classors>> classors) {
        this.classors = classors;
    }

    public LiveData<List<Classors>> getClassors() {
        return classors;
    }
}
