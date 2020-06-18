package by.gsu.winter20.menu;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;


public class CalcTest {

    private Calc testObject = new Calc();

    @Test
    void testDivSimple() {
        int result = testObject.div(4, 2);

        assertEquals(2, result);
    }

    @Test
    void testDivisionByZero() {
        assertThrows(ArithmeticException.class, () -> testObject.div(4, 0));
    }


}
