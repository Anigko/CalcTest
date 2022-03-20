import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalcTest {

    Calculator calc;

    @BeforeAll
    public static void beforeAllMethod() {
        System.out.println("BeforeAll call");
    }

    @BeforeEach
    public void beforeEachMethod() {
        System.out.println("BeforeEach call");
        calc = new Calculator();
    }

    @AfterEach
    public void afterEachMethod() {
        System.out.println("AfterEach call");
    }

    @AfterAll
    public static void afterAllMethod() {
        System.out.println("AfterAll call");
    }

    @Test
    public void testMinus() {
        int x = 100, y = 55, expected = 45;
        int result = calc.minus.apply(x, y);
        assertEquals(expected, result);
        assertNotNull(result);
    }

    @ParameterizedTest
    @MethodSource("multiValueTest")
    public void testParameterizedSubtract(int x, int y, int expected) {
        int result = calc.multiply.apply(x, y);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> multiValueTest() {
        return Stream.of(
                Arguments.of(30, 10, 300),
                Arguments.of(10, 10, 100)
        );
    }

    @Test
    public void testDivideByZero() {
        int x = 10;
        int y = 0;
        int expected = 0;
        int result = calc.divide.apply(x, y);
        assertEquals(expected, result);
    }
}
