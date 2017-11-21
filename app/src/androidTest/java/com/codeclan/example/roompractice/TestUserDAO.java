package com.codeclan.example.roompractice;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by user on 21/11/2017.
 */

@RunWith(AndroidJUnit4.class)
public class TestUserDAO {
    private UserDao userDao;
    private AppDatabase db;

    @Before
    public void setUp() throws Exception {
        Context context = InstrumentationRegistry.getTargetContext();
        db = Room.inMemoryDatabaseBuilder(context, AppDatabase.class).build();
        userDao = db.userDao();
    }

    @After
    public void tearDown() throws Exception {
        db.close();
    }

    @Test
    public void testAddUser() throws Exception {
        User user = new User("Jim", "Bob");
        userDao.insertAll(user);
        ArrayList<User> users = new ArrayList<>(userDao.getAll());
        assertEquals(1, users.size());
    }

    @Test
    public void testDeleteAll() throws Exception {
        User user = new User("Jim", "Bob");
        userDao.insertAll(user);
        userDao.deleteAll();

        ArrayList<User> users = new ArrayList<>(userDao.getAll());
        assertEquals(0, users.size());
    }
}
