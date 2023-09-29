package com.epam.training.arturs_ziemelis;

import com.epam.training.arturs_ziemelis.pages.PastebinPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PastebinTest {
    private WebDriver driver;
    private PastebinPage pastebinPage;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pastebinPage = new PastebinPage(driver);
    }

    @Test
    public void testCreateNewPaste() throws InterruptedException {
        pastebinPage.openPage("https://pastebin.com/");
        Thread.sleep(5000);
        pastebinPage.clickAgreeBlockerButton();
        Thread.sleep(5000);
        pastebinPage.enterCode("Hello from WebDriver");
        Thread.sleep(5000);
        pastebinPage.setExpirationToTenMinutes();
        Thread.sleep(5000);
        pastebinPage.setPasteName("helloweb");
        Thread.sleep(5000);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
