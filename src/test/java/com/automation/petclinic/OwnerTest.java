package com.automation.petclinic;

import io.github.bonigarcia.wdm.DriverManagerType;
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

public class OwnerTest {

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
        driver.get("http://139.59.149.247:8000");

        WebElement ownersMenuItem = driver.findElement(By.xpath("//a[@class='dropdown-toggle'][text()='Owners']"));
        ownersMenuItem.click();

        WebElement allOwners = driver.findElement(By.xpath("//a[@routerlink='/owners']"));
        allOwners.click();

        WebElement ownersTable = driver.findElement(By.xpath("//*[@class='table-responsive']"));
        assertTrue(ownersTable.isDisplayed());

        List<WebElement> ownerList= ownersTable.findElements(By.xpath(".//tbody/tr"));

        WebElement userRow = ownerList.get(0);

        Owner owner = new Owner();
        owner.setName(userRow.findElement(By.xpath("./td/a")).getText());
        owner.setAddress(userRow.findElement(By.xpath("./td/td[2]")).getText());
        owner.setCity(userRow.findElement(By.xpath("./td/td[3]")).getText());
        owner.setTelephone(userRow.findElement(By.xpath("./td/td[4]")).getText());
        owner.setPets(userRow.findElement(By.xpath("./td/td[5]")).getText());

        System.out.println(owner);

    }
}
