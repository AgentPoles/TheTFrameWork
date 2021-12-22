package com.mycompany.myapp.thetframework;

        import android.arch.lifecycle.ViewModel;
        import android.arch.lifecycle.ViewModelProvider;
        import android.support.annotation.NonNull;

public class MyViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private final AppDatabase mdb;
    private final int id;

    public MyViewModelFactory(AppDatabase mdb, int id){
        this.id = id;
        this.mdb = mdb;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new MySinglesViewModel(mdb, id);
    }
}