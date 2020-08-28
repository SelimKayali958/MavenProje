package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day08_BeforeAfterClass {

    @BeforeClass // bu annotationa sahip metod her class calismadan once calisir sadece 1 kere
    public static void setup(){
        System.out.println("setup calisti");
    }

    @Test
    public  void test1(){
        System.out.println("test1 calisti");
        /*
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://google.com");
        driver.quit();
        */

    }

    @Test
    public  void test2() {
        System.out.println("test2 calisti");
    }


    @AfterClass // bu annotationa sahip metod her classdaki tester calistirildiktan sonra calisir sadece 1 kere
    public static void tearDown(){
        System.out.println("tearDown calisti");
    }






}
