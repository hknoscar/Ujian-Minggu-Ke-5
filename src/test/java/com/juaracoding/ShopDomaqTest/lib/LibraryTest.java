package com.juaracoding.cucumber.lib;

import com.juaracoding.cucumber.drivers.DriverSingleton;
import com.juaracoding.cucumber.utils.Regular;
import com.juaracoding.cucumber.utils.RegularPage;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class LibraryTest {
    public static WebDriver driver;

    @Before
    public static void setUp() {
        DriverSingleton.getInstance(Regular.CHROME);
        driver = DriverSingleton.getDriver();
    }

    @AfterAll
    public static void close_object() {
        RegularPage.delayDuration(3);
        DriverSingleton.closeObjectInstance();
    }
}
