package selIntro.waits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.function.Function;

public class FluentWaitTest {
    //https://the-internet.herokuapp.com/dynamic_loading/1
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.findElement(By.cssSelector("div[id='start'] button")).click();

        Wait<WebDriver> fwait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(5));

        WebElement output = fwait.until(new Function<WebDriver,WebElement>(){
               public WebElement apply(WebDriver driver){
                   if(driver.findElement(By.cssSelector("div[id='finish'] h4")).isDisplayed()) {
                       return driver.findElement(By.cssSelector("div[id='finish'] h4"));
                   }else
                   return null;
        }});
        System.out.println(output.isDisplayed());
        System.out.println("output = "+ output.getText());
        driver.close();
        driver.quit();
    }

}
