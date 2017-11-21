package com.codeclan.example.roompractice;

import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Open DB connection
        AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "users-database")
                .allowMainThreadQueries().build();

        // Grab a reference to the userDAO
        UserDao userDao = db.userDao();

        // Delete existing users
        userDao.deleteAll();

        // Create an array of users to add
        User[] users = new User[4];
        users[0] = new User("John", "McC");
        users[1] = new User("Ally", "McG");
        users[2] = new User("Steve", "MJ");
        users[3] = new User("Colin", "B");

        // add them to the database
        userDao.insertAll(users);

        // Get them back from the database ¯\_(ツ)_/¯
        ArrayList<User> savedUsers = new ArrayList<>(userDao.getAll());

        // Chuck them into an adapter
        ListView lv = findViewById(R.id.listview);
        UserAdapter adapter = new UserAdapter(this, savedUsers);
        lv.setAdapter(adapter);

        db.close();
    }
}
