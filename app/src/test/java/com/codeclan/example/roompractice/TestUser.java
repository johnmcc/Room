package com.codeclan.example.roompractice;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by user on 21/11/2017.
 */

public class TestUser {
    User user;

    @Before
    public void setUp() throws Exception {
        user = new User("John", "McC");
    }

    @Test
    public void testGetFullName() throws Exception {
        assertEquals("John McC", user.getFullName());
    }
}
