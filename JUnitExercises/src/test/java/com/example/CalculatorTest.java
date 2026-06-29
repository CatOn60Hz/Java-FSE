package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("Calculator")
public class CalculatorTest {
    Calculator calculator = new Calculator();

    @Test
    void testAdd() {
        assertEquals(30, calculator.add(10, 20));
    }

    @Test
    void testSubtract() {
        assertEquals(15, calculator.subtract(20, 5));
    }
}
