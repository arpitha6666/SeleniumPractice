package selIntro.actionsWindowsFrames;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionDemo {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com");
        Actions a = new Actions(driver);
        WebElement moveElement =driver.findElement(By.cssSelector("a[id='nav-link-accountList']"));
        a.moveToElement(moveElement).build().perform();
        //Write the text in capital letters & double click on the text entered
        a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
        a.moveToElement(moveElement).contextClick().build().perform();
        driver.close();
        driver.quit();

    }
}
