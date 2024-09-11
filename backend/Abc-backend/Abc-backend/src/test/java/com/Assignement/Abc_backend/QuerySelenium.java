package com.Assignment.Abc_Restaurant;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class QuerySelenium{

    
    WebDriver driver;

    @BeforeEach
    public void setUp(){

        System.setProperty("webdriver.chrome.driver", "D:\\\\Abc_Restaurant\\\\src\\\\chromedriver.exe");
        driver=new ChromeDriver();
    }

    @Test
    public void testquery(){

         driver.get("http://localhost:8080/query");

 driver.findElement(By.id("username")).sendKeys("niku");
 driver.findElement(By.id("email")).sendKeys("niku@gmail.com");
 driver.findElement(By.id("message")).sendKeys("Love the restaurant");


 driver.findElement(By.id("submit")).click();
    }
    

    @AfterEach
     public void tearDown(){
        driver.quit();
     }
}