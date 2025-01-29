package selIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Locators {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.id("inputUsername")).sendKeys("arpitha");
        driver.findElement(By.name("inputPassword")).sendKeys("arpitha");
        driver.findElement(By.className("submit")).click();
        System.out.print(driver.findElement(By.cssSelector("p.error")).getText());
        driver.findElement(By.linkText("Forgot your password?")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("John");
        //Thread.sleep(1000);
        driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("john.ra@gmail.com");
        //Thread.sleep(1000);
        //driver.findElement(By.cssSelector("input[placeholder='Email']")).clear();
        //Thread.sleep(1000);
        driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("john.ra@gmail.com");
        //Thread.sleep(1000);
        driver.findElement(By.xpath("//form/input[3]")).sendKeys("2547888928");
        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
        System.out.println(driver.findElement(By.cssSelector("form p")).getText());
        driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#inputUsername")).sendKeys("rahul");
        driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
        driver.findElement(By.id("chkboxOne")).click();
        driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
        Thread.sleep(2000);
        driver.close();
        driver.quit();

    }
}
