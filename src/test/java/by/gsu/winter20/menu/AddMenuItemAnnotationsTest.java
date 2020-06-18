package by.gsu.winter20.menu;

import by.gsu.winter20.utils.Container;
import by.gsu.winter20.utils.Factory;
import by.gsu.winter20.utils.LocalContainer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AddMenuItemAnnotationsTest {

    @Mock
    private Container<String> container;

    @Mock
    private Factory<String> factory;

    @InjectMocks
    private AddMenuItem<String> testObject;

    @BeforeEach
    void init() {
        when(factory.create()).thenReturn("hello!");
    }


    @Test
    void testExecute() {
        testObject.execute();

        verify(factory, times(1)).create();
        verifyNoMoreInteractions(factory);

        verify(container).add(eq("hello!"));
        verifyNoMoreInteractions(container);
    }

}