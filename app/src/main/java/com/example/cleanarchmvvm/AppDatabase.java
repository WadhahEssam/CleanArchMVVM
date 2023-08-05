package com.example.cleanarchmvvm;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

// @Database defines the whole database of your app and what tables it has
// the version is helpful whenever you make changes to the database, you can
// provide a mechanism to migrate users from an old version to a new version
@Database(entities = {Note.class}, version = 1) // here you define the tables you are going to have + the version of the database
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase instance; // because we are going to make this class singleton


    public abstract NoteDao noteDao();


    // this is just a general way of creating singletons
    // synchronized means that only one thread can create
    // this instance at a time, so you avoid race conditions
    public static synchronized AppDatabase getInstance(Context context) {
        if (instance == null) {
                // you can't just do a new AppDatabase, because this is an abstract class, so we ask room to build it for us
                instance = Room.databaseBuilder(
                                context.getApplicationContext(),
                                AppDatabase.class,
                                "note_database") // this is telling room the name of the database
                        .fallbackToDestructiveMigration() // this is telling room the mechanism of migrating, now if there is a new version, it will just destroy the previous one
                        .build();
        }
        return instance;
    }


}
