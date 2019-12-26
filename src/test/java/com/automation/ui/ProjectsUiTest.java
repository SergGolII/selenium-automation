package com.automation.ui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ProjectsUiTest {
    private WebDriver driver;


    String pageTitle = "SeleniumHQ Browser Automation";
    String projectsUrl = "https://selenium.dev/projects/";
    String projectsPageTitle = "Selenium Projects";

    @BeforeClass
    public void setUpDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void projectTest(){
        String baseUrl = "https://selenium.dev/";
        driver.get(baseUrl);
        WebElement projectLink = driver.findElement(By.cssSelector("#navbar a[href='/projects']"));
        projectLink.click();

        String projectTitle = driver.getTitle();
        assertEquals(projectTitle, "Selenium project");
    }

}
