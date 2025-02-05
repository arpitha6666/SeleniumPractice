package selIntro.actionsWindowsFrames;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class WindowHandle {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/loginpagePractise/#/");
        driver.findElement(By.cssSelector("a.blinkingText")).click();
        //switch parent to child
        Set<String> windows = driver.getWindowHandles();
        Iterator itr = windows.iterator();
        String parentId = itr.next().toString();
        String childId = itr.next().toString();
        driver.switchTo().window(childId);
        String text =driver.findElement(By.cssSelector(".im-para.red")).getText();
        System.out.println(text);
        String email= text.split("at")[1].split("with")[0].trim();
        driver.switchTo().window(parentId);
        driver.findElement(By.id("username")).sendKeys(email);
        driver.close();
        driver.quit();

    }
}
