package com.hanhnt.mathutil;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

public class SalesServiceTest {
    private SalesService service;
    @BeforeEach void setUp() { service = new SalesService(); }

    @Test void testCalculateSubtotal_Normal() {
        assertEquals(1500, service.calculateSubtotal(new Product("P1", "Laptop", 500, 3)));
    }
    @Test void testCalculateSubtotal_NullProduct() {
        assertThrows(IllegalArgumentException.class, () -> service.calculateSubtotal(null));
    }

    @ParameterizedTest
    @CsvSource({"999.99, 0", "1000, 50", "4999.99, 249.9995", "5000, 500", "9999.99, 999.999", "10000, 1500"})
    void testCalculateDiscount_Boundary(double subtotal, double expectedDiscount) {
        assertEquals(expectedDiscount, service.calculateDiscount(subtotal), 0.001);
    }
    @Test void testCalculateDiscount_Negative() {
        assertThrows(IllegalArgumentException.class, () -> service.calculateDiscount(-10));
    }

    @ParameterizedTest
    @CsvSource({"1999.99, 50", "2000, 0", "2500, 0"})
    void testCalculateShippingFee(double subtotal, double expectedFee) {
        assertEquals(expectedFee, service.calculateShippingFee(subtotal));
    }
    @Test void testCalculateShippingFee_Negative() {
        assertThrows(IllegalArgumentException.class, () -> service.calculateShippingFee(-10));
    }

    @Test void testCalculateTotal() {
        assertEquals(850, service.calculateTotal(new Product("P3", "Keyboard", 400, 2)));
    }

    @ParameterizedTest
    @CsvSource({"999.99, REGULAR", "1000, SILVER", "4999.99, SILVER", "5000, GOLD", "9999.99, GOLD", "10000, VIP"})
    void testClassifyCustomer_Boundary(double total, String expectedType) {
        assertEquals(expectedType, service.classifyCustomer(total));
    }
    @Test void testClassifyCustomer_Negative() {
        assertThrows(IllegalArgumentException.class, () -> service.classifyCustomer(-100));
    }
}