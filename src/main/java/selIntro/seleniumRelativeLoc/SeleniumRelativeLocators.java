package selIntro.seleniumRelativeLoc;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.time.Duration;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class SeleniumRelativeLocators {
    public static void main(String[] args) throws InterruptedException, IOException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        WebElement nameEditBox =driver.findElement(By.cssSelector("[name='name']"));
        System.out.println(driver.findElement(with(By.tagName("label")).above(nameEditBox)).getText());
        //below
        WebElement dateOfBirthLabel= driver.findElement(By.cssSelector("[for='dateofBirth']"));
        driver.findElement(with(By.tagName("input")).below(dateOfBirthLabel)).click();

        WebElement icecreamText=driver.findElement(By.cssSelector("[for='exampleCheck1']"));
        driver.findElement(with(By.tagName("input")).toLeftOf(icecreamText)).click();

        WebElement radioSubmit = driver.findElement(By.id("inlineRadio1"));
        System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(radioSubmit)).getText());

        Thread.sleep(2000);
        driver.close();
        driver.quit();

    }
}
