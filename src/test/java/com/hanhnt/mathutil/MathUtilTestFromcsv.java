package com.hanhnt.mathutil;

import com.hanhnt.mathutil.core.MathUtil;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import static org.junit.jupiter.api.Assertions.*;

public class MathUtilTestFromcsv {

    @ParameterizedTest
    // Chỉ định đường dẫn tới file CSV, numLinesToSkip = 0 vì file này không có dòng chữ tiêu đề
    @CsvFileSource(resources = "/factorial_test_data.csv", numLinesToSkip = 0)
    public void testGetFactorialGivenRightArgumentReturnsWell(int n, long expected) {
        assertEquals(expected, MathUtil.getFactorial(n));
    }
}