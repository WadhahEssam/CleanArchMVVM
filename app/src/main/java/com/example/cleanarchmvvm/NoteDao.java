package com.example.cleanarchmvvm;

// DAO stands for Data Access Object, which is a class responsible for accessing the data from the room
// DAO has to be either interfaces or abstract classes because we don't define the method body
// room will automatically generate all the necessary code with use

// it is usually recommended to add 1 dao for each entity
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface NoteDao {

    @Insert
    void insert(Note note);

    @Update
    void update (Note note);

    @Delete
    void delete(Note note);

    @Query("DELETE FROM note_table") // if you are going to define a custom function
    void deleteAllNotes();

    @Query("SELECT * FROM note_table ORDER BY priority DESC")
    LiveData<List<Note>> getAllNotes(); // the return type has to match the return value of the query, room can also return LiveData Object. List<Note> or LiveData<List<Note>> are all valid but working differently
}
