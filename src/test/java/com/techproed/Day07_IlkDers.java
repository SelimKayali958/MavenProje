package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.List;
import java.util.concurrent.TimeUnit;

public class Day07_IlkDers {
    public static void main(String[] args) {
    //Browserlari kullabillemek icin WebDriverManager kutuphanesi kullaniliyor
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.amazon.com");

        //id ile......
   //     WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));

        WebElement aramaKutusu = driver.findElement(By.xpath("//input[@dir='auto']"));
        aramaKutusu.sendKeys("samsung headphones"+ Keys.ENTER);// enter yapar

        WebElement sonucSayisi = driver.findElement(By.xpath("//span[@dir='auto']"));
        System.out.println(sonucSayisi.getText());

        WebElement ilkUrun = driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
        System.out.println(ilkUrun.getText());


        List<WebElement> urunler = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
        // 0. index den basliyor
        for (WebElement w:urunler){
            System.out.println(w.getText());
        }






    }
}
