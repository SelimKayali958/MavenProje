package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day10_isDisplayedOrnek {

    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @AfterClass
    public static void tearDown(){
        driver.quit();

    }
    @Before
    public void testtenOnce(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://www.bestbuy.com");
    }
    @After
    public void testtenSonra(){
    driver.quit();
    }

    @Test
    public void titleTest (){

    String title =   driver.getTitle();
    boolean iceryormu = title.contains("Best");
    Assert.assertTrue(iceryormu);
    }

    @Test
    public void logoTest (){
        WebElement logo = driver.findElement(By.xpath("//img[@alt='Best Buy Logo']"));
        boolean logoGorunuyorMu = logo.isDisplayed();
        Assert.assertTrue(logoGorunuyorMu);
    }
    @Test
    public void linkTest (){
        WebElement link = driver.findElement(By.xpath("//img[@alt='Mexico']"));
        boolean linkGorunuyorMu = link.isDisplayed();
        Assert.assertTrue(linkGorunuyorMu);
    }


}
