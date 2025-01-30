package selIntro.locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;


import java.time.Duration;

public class LocatorsTwo {
    public static void main(String[] args) throws InterruptedException {
        String userName = "rahul";
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        String password =getPassword(driver);
        System.out.println("Password : "+password);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.id("inputUsername")).sendKeys(userName);
        driver.findElement(By.name("inputPassword")).sendKeys(password);
        driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
        Thread.sleep(1000);
        System.out.println("TagName is : "+ driver.findElement(By.tagName("p")).getText());
        Assert.assertEquals(driver.findElement(By.tagName("p")).getText(),"You are successfully logged in.");
        Assert.assertEquals((driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText()),"Hello "+userName+",");
        driver.findElement(By.xpath("//*[text()='Log Out']")).click();
        driver.close();
        driver.quit();

    }
    public static String getPassword(WebDriver driver) throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.linkText("Forgot your password?")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
        String passwordTxt =driver.findElement(By.cssSelector("form p")).getText();
        String password = passwordTxt.split("'")[1];
        return password;
    }
}
