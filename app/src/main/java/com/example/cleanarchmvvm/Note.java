package com.example.cleanarchmvvm;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

// Room will create our table when it sees this @Entity annotation
@Entity(tableName = "note_table") // by default the table name will be note, but we can specify it here
public class Note {
    @PrimaryKey(autoGenerate = true) // so you don't have to manage it
    private int id;
    private String title;
    private String description;
    @ColumnInfo(name = "priority") // you do this if you want to change the column name.
    private int priority;

    public Note(String title, String description, int priority) {
        this.title = title;
        this.description = description;
        this.priority = priority;
    }

    // if a room column is not set by the constructor (auto generated), you have to add a setter for it
    // in order for room to know how to set its value, if you don't do this you will usually get a compile error
    // which is something good.
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }
}
