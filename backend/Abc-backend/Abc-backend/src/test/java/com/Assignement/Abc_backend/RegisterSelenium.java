package com.Assignment.Abc_Restaurant;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegisterSelenium {
    
    
    WebDriver driver;

    @BeforeEach
    public void setUp(){

        System.setProperty("webdriver.chrome.driver", "D:\\\\Abc_Restaurant\\\\src\\\\chromedriver.exe");
        driver=new ChromeDriver();
    }

    @Test
public void testregister(){
 
    driver.get("http://localhost:8080/register");

   
    driver.findElement(By.id("username")).sendKeys("SM");
    driver.findElement(By.id("email")).sendKeys("sm@gmail.com");
    driver.findElement(By.id("password")).sendKeys("sawdha123");
    driver.findElement(By.id("role")).sendKeys("Customer");

    driver.findElement(By.id("submit")).click();

   
     }


    @AfterEach
     public void tearDown(){
        driver.quit();
     }
}
