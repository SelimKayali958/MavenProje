package com.techproed;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.List;
import java.util.concurrent.TimeUnit;
public class Day10_DropDown {

    // 1. Amazon.com'a gidelim.
    // 2. DropDown üzerinde Software seçelim.
    // 3. Arama kutusuna JAVA yazalım ve arama yapalım.
    // 4. Sonuç sayısını ekrana yazdıralım.

    static WebDriver driver; // instance variable
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void test1(){
        driver.get("http://amazon.com");
        WebElement dropDown = driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(dropDown);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }

        select.selectByVisibleText("Software");

        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Java");
        aramaKutusu.submit();

        WebElement snc = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(snc.getText());

        Assert.assertTrue(snc.getText().contains("Java"));

    }

    @AfterClass
    public static void tearDown (){
        driver.quit();
    }
}