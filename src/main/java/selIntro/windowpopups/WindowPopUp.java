package selIntro.windowpopups;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.time.Duration;

public class WindowPopUp {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://admin:admin@the-internet.herokuapp.com/");
        driver.findElement(By.linkText("Basic Auth")).click();
        String textHeading = driver.findElement(By.cssSelector("div[class='example'] h3")).getText();
        Assert.assertEquals(textHeading,"Basic Auth");
        String text = driver.findElement(By.tagName("p")).getText();
        Assert.assertEquals(text,"Congratulations! You must have the proper credentials.");
        driver.close();
    }
}
