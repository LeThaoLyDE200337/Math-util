package com.hanhnt.mathutil;

import com.hanhnt.mathutil.AccountService;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountServiceTest {
    private final AccountService accountService = new AccountService();

    @ParameterizedTest
    @CsvFileSource(resources = "/test-data.csv", numLinesToSkip = 1)
    void testRegisterAccount(String username, String password, String email, boolean expected) {
        assertEquals(expected, accountService.registerAccount(username, password, email));
    }
}