package selIntro.radiobutton;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.time.Duration;

public class RadioButtons {

//ctl00_mainContent_rbtnl_Trip_0
public static void main(String[] args) throws InterruptedException {
    WebDriverManager.firefoxdriver().setup();
    WebDriver driver = new FirefoxDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
    driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();
    if(driver.findElement(By.id("Div1")).getDomAttribute("style").contains("1")){
        Assert.assertTrue(true);
    }else{
        Assert.assertTrue(false);
    }
    driver.close();
    driver.quit();

}
}
