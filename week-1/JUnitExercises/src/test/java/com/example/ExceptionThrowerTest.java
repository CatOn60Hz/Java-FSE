package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class ExceptionThrowerTest {
    @Test
    void testThrowException() {
        ExceptionThrower exceptionThrower = new ExceptionThrower();
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> exceptionThrower.throwException()
        );
        assertEquals("This is an exception", exception.getMessage());
    }
}
