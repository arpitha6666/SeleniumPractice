package selIntro.actionsWindowsFrames;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;

public class FramesTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://jqueryui.com/droppable");
        List<WebElement> listOfIframes =driver.findElements(By.tagName("iframe"));
        System.out.println(listOfIframes.size());
        //to find iframes via indexes
        //driver.switchTo().frame(0);
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
        Actions a = new Actions(driver);
        WebElement src =driver.findElement(By.id("draggable"));
        WebElement dest =driver.findElement(By.id("droppable"));
        a.dragAndDrop(src,dest).build().perform();
        //to come out of iframe
        driver.switchTo().defaultContent();
        driver.close();
        driver.quit();

    }
}
