package com.wind;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Windoes {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Thasif Ahamed\\eclipse-workspace\\Windows\\Driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.w3schools.com/jsref/met_win_alert.asp");
        driver.findElement(By.xpath("(//a[text()='Try it Yourself »'])[2]")).click();
        
        Set<String> allwindowid = driver.getWindowHandles();
        Iterator<String> seprateid = allwindowid.iterator();
        String patentid = seprateid.next();
        String childid = seprateid.next();
        driver.switchTo().window(childid);
        
         WebElement ff = driver.findElement(By.xpath("//iframe[@id='iframeResult']"));
        
         driver.switchTo().frame(ff);
         driver.findElement(By.xpath("//button[text()='Try it']")).click();
         Alert alert = driver.switchTo().alert();
         alert.accept();
         driver.switchTo().window(patentid);
         driver.close();
         
        
	}

}
