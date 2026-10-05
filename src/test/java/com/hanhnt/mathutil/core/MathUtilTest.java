package com.hanhnt.mathutil.core;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MathUtilTest {
    @Test
    public void testGetFactorialGivenRightArgumentReturnsWell() {
        assertEquals(120, MathUtil.getFactorial(5));
        assertEquals(720, MathUtil.getFactorial(6));
    }
    @Test
    public void testGetFactorialGivenWrongArgumentThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> MathUtil.getFactorial(-5));
    }
}