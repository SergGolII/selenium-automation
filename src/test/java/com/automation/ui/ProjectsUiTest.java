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
    String baseUrl = "https://selenium.dev/";

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

    public void transferTo(String ident, String title){
        driver.get(baseUrl);
        WebElement projectLink = driver.findElement(By.cssSelector("#navbar a[href='/"+ident+"']"));
        projectLink.click();

        String projectTitle = driver.getTitle();
        assertEquals(projectTitle, title);
    }

    @Test
    public void projectTest(){
        transferTo("projects", "Selenium Projects");
    }

    @Test
    public void downloadsTest() {
        transferTo("downloads", "Downloads");

    }

    @Test
    public void documentationTest() {
        transferTo("documentation", "The Selenium Browser Automation Project :: Documentation for Selenium");

    }

    @Test
    public void supportTest() {
        transferTo("support", "Selenium Support");

    }

    @Test
    public void blogTest() {
        transferTo("blog", "Selenium Blog");

    }


}
