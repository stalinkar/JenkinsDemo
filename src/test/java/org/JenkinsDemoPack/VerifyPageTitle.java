package org.JenkinsDemoPack;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class VerifyPageTitle {

    @Parameters("Browser")
    @Test
    public void startBrowser(String browserName){
        System.out.println("Parameter is "+browserName);
        WebDriver driver = null;
        if (browserName.contains("Chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }else if (browserName.contains("Edge")){
            WebDriverManager.chromedriver().setup();
            driver = new EdgeDriver();
        }
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
        Assert.assertEquals(driver.getTitle(), "Google", "Title does not match");
        driver.quit();
    }
}