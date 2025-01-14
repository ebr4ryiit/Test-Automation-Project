package com.Belbim2.driver;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {
    public static WebDriver driver;

    //başında gerçekleşir ve 1 kere gerçekleşir
    @BeforeAll
    public static void beforeAll() {
    }

    //her bir test başlamadan önce bu methodu çağır.
    @BeforeEach
    public void before() {
        driver = new ChromeDriver();
        //açılan tarayıcının boyutunu ayarlama
        driver.manage().window().maximize();
        driver.get("https://www.istanbulkart.istanbul/");
    }

    //tarayıcı kapatma
    @AfterEach
    public void after() {
        if (driver != null) {
            driver.quit(); //tarayıcı kapatır close sekmeyi kapatır

        }

    }

    @AfterAll
    public static void afterAll() {

    }
}
