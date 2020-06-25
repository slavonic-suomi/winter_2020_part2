package by.gsu.winter20.utils;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class LocalContainerTest {

    private LocalContainer<String> testObject = new LocalContainer<>();

    @Test
    @Order(1)
    void size() {
        int originalSize = testObject.size();

        testObject.add("someVal");

        assertEquals(originalSize + 1, testObject.size());

        testObject.delete(0);

        assertEquals(originalSize, testObject.size());
    }

    @Test
    @Order(2)
    void add() {
        int originalSize = testObject.size();

        testObject.add("someVal");

        assertEquals(originalSize + 1, testObject.size());

        assertTrue(testObject.getAll().contains("someVal"));
    }

    @Test
    void set() {
    }

    @Test
    void delete() {
        testObject.add("valueForDelete");
        int originalSize = testObject.size();

        testObject.delete(originalSize - 1);

        assertEquals(originalSize - 1, testObject.size());
    }

    @Test
    void getAll() {
        int originalSize = testObject.size();

        Collection<String> collectionToTest = testObject.getAll();

        assertEquals(originalSize, collectionToTest.size());
    }
}