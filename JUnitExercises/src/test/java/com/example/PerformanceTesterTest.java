package com.example;

import static org.junit.jupiter.api.Assertions.assertTimeout;
import java.time.Duration;
import org.junit.jupiter.api.Test;

public class PerformanceTesterTest {
    PerformanceTester tester = new PerformanceTester();

    @Test
    void testPerformTaskTimeout() {
        assertTimeout(
            Duration.ofSeconds(2),
            () -> tester.performTask()
        );
    }
}
