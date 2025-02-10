package selIntro.seleniumRelativeLoc;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class InvokingMultipleWindows {
    public static void main(String[] args) throws InterruptedException, IOException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        WebElement nameEditBox =driver.findElement(By.cssSelector("[name='name']"));
        //driver.switchTo().newWindow(WindowType.TAB);
        driver.switchTo().newWindow(WindowType.WINDOW);
       Set<String> windows= driver.getWindowHandles();
       Iterator it = windows.iterator();
       String parentId= it.next().toString();
       String childId = it.next().toString();
       driver.switchTo().window((childId));
        driver.get("https://rahulshettyacademy.com/");

        Thread.sleep(1000);
        String courseName = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']")).get(1).getText();
        driver.switchTo().window(parentId);
        nameEditBox.sendKeys(courseName);
        WebElement name  =driver.findElement(By.cssSelector("[name='name']"));
        File file = name.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("E:/partialSS.png"));

        //get height and width
        System.out.println(name.getRect().getDimension().getHeight());
        System.out.println(name.getRect().getDimension().getWidth());
        driver.close();
        driver.quit();
    }
}
