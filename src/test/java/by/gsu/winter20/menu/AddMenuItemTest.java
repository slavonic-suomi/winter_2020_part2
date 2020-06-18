package by.gsu.winter20.menu;

import by.gsu.winter20.utils.Container;
import by.gsu.winter20.utils.Factory;
import by.gsu.winter20.utils.LocalContainer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AddMenuItemTest {

    private Container<String> container = new LocalContainer<>();
//    private Factory<String> factory = () -> "hello!";  //it's a stub object
    private Factory<String> factory = mock(Factory.class);
    private AddMenuItem<String> testObject = new AddMenuItem<>(
        container, factory
    );

    @BeforeEach
    void init() {
        when(factory.create()).thenReturn("hello!");
    }

    @Test
    void testGetOrder() {
        int order = testObject.getOrder();

        assertEquals(1, order);
    }

    @Test
    void testGetTitle() {
        String title = testObject.getTitle();

        assertEquals("Add element", title);
    }

    @Test
    void testExecute() {
        testObject.execute();

        String values = container.getAll().iterator().next();

        assertEquals(1, container.size());
        assertEquals("hello!", values);

        verify(factory, times(1)).create();
        verifyNoMoreInteractions(factory);
    }

}