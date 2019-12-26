package com.automation.petclinic;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class Dom {

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
        public void tearDown(){
            driver.quit();
        }

        @Test
        public void addOwner() {
            driver.get("http://the-internet.herokuapp.com/challenging_dom");

            WebElement ownersTable = driver.findElement(By.xpath("//*[@class='large-10 columns']"));
            assertTrue(ownersTable.isDisplayed());

            

        }
    }
