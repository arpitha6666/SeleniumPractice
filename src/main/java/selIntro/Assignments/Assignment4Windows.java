package selIntro.Assignments;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.bouncycastle.util.Arrays;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class Assignment4Windows {
    //
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://the-internet.herokuapp.com/windows");
        driver.findElement(By.xpath("//div[@class='example']/a")).click();
        //driver.findElement(By.cssSelector("div[class='example'] a")).click();
        Set<String> windows =driver.getWindowHandles();
        Iterator itr = windows.iterator();
        String parentWinId = itr.next().toString();
        String childWinId = itr.next().toString();

        driver.switchTo().window(childWinId);
        //get the element from child window
        //System.out.println(driver.findElement(By.xpath("//div[@class='example']/h3")).getText());
        System.out.println(driver.findElement(By.cssSelector("div[class='example'] h3")).getText());
        //switch to parent window
        driver.switchTo().window(parentWinId);
        //get the text displayed
        //System.out.println(driver.findElement(By.xpath("//div[@class='example']/h3")).getText());
        System.out.println(driver.findElement(By.cssSelector("div[class='example'] h3")).getText());
        driver.close();
        driver.quit();

    }
}
