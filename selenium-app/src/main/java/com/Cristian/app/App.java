package com.Cristian.app;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Hello world!
 *
 */
public class App 
{
    @Test
        public void test1(){
        WebDriver driver= new FirefoxDriver();
        driver.get("http://www.google.com");
        driver.close();
        driver.quit();

    }

}
