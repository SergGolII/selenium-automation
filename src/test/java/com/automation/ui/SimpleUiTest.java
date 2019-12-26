package com.automation.ui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SimpleUiTest {

    private WebDriver driver;

    @BeforeClass
    public void setUpDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();

    }

    @AfterMethod
    public void tearDonw(){
        driver.quit();
    }

    @Test
    public void openSeleniumUrl(){
        String baseUrl = "https://selenium.dev/";
        String pageTitle = "SeleniumHQ Browser Automation";
        String projectsUrl = "https://selenium.dev/projects/";
        String projectsPageTitle = "Selenium Projects";


        assertPageTitle(pageTitle);

        driver.get(projectsUrl);
        assertEquals(driver.getCurrentUrl(), projectsUrl);
        assertEquals(driver.getTitle(), projectsPageTitle);

        driver.navigate().back();
        assertEquals(driver.getCurrentUrl(), baseUrl);



    }

    @Test
    public void openSeleniumDocumentation(){
        driver.get("https://selenium.dev/documentation/en/");
    }

    private void assertPageTitle(String pageTitle){
        String currentTitle = driver.getTitle();
        assertEquals(currentTitle, pageTitle, "Wrong");
    }

}
