package com.eurotech.tests;

import com.eurotech.pages.LoginPage;
import com.eurotech.utils.ConfigurationReader;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTests extends TestBase {

    @Test
    public void successLoginTest() {
        context.driver.get(ConfigurationReader.get("base_url"));
        assertTrue(new LoginPage(context)
                .loginAsStandardUser()
                .getFooterText()
                .contains("Sauce Labs"));
    }

    @Test
    public void emptyLoginTest() {
        context.driver.get(ConfigurationReader.get("base_url"));

        assertEquals("Epic sadface: Username is required",
                new LoginPage(context).incorrectLoginAs("",""));
    }

    @Test
    public void blockedUserLoginTest() {
        context.driver.get(ConfigurationReader.get("base_url"));
        assertEquals(
                "Epic sadface: Sorry, this user has been locked out.",
                new LoginPage(context).incorrectLoginAs("locked_out_user","secret_sauce")
        );
    }
}
