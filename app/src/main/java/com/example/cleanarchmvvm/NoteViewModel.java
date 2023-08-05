package com.example.cleanarchmvvm;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;


// ViewModels are part of the android archetecture components.
// they are responsible for storing and persist data from the model
// and communicate with the views about the changes
// also it handles the events coming from the activity or screen
// and pass them to the model

// Very important note about the ViewModels is that they survive configration
// changes, for example rotating the screen.

// it is important not to have a reference of the activity inside the view model
// because when the activity is restarted, its going to be a mess
public class NoteViewModel extends AndroidViewModel {

    private AppRepository repository;
    private LiveData<List<Note>> allNotes;

    public NoteViewModel(@NonNull Application application) { // reference the application that we can pass to the database
        super(application);
        repository = new AppRepository(application);
        allNotes = repository.getAllNotes();
    }

    // activity and views have access to the ViewModel, so they are only exposed to this
    // functions, and they don't have access to the repository functions at all
    public void insert(Note note) {
        repository.insert(note);
    }

    public void update(Note note) {
        repository.update(note);
    }

    public void delete(Note note) {
        repository.delete(note);
    }

    public void deleteAllNotes() {
        repository.deleteAllNotes();
    }

    public LiveData<List<Note>> getAllNotes() {
        return allNotes;
    }
}
