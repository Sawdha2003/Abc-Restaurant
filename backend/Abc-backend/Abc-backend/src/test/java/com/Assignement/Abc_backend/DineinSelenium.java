package com.Assignment.Abc_Restaurant;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DineinSelenium{


    WebDriver driver;

    @BeforeEach
    public void setUp(){

        System.setProperty("webdriver.chrome.driver", "D:\\Abc_Restaurant\\src\\chromedriver.exe");
        driver=new ChromeDriver();
    }

    @Test
    public void testdinein(){

        
    driver.get("http://localhost:8080/Dinein/Add");

    
    driver.findElement(By.id("username")).sendKeys("niku");
   
    driver.findElement(By.id("password")).sendKeys("niku123");
    


    }
    
    @AfterEach
     public void tearDown(){
        driver.quit();
     }

}