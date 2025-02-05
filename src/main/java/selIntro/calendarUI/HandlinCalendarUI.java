package selIntro.calendarUI;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class HandlinCalendarUI {
    //react-date-picker__inputGroup
    public static void main(String[] args) throws InterruptedException {
        String month="2";
        String date = "15";
        String year = "2027";
        String[] expectedList = {month,date,year};
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.findElement(By.cssSelector(".react-date-picker__inputGroup")).click();
        driver.findElement(By.cssSelector(".react-calendar__navigation__label__labelText")).click();
        driver.findElement(By.cssSelector(".react-calendar__navigation__label__labelText")).click();
        driver.findElement(By.xpath("//button[text()='"+year+"']")).click();
        driver.findElements(By.cssSelector(".react-calendar__year-view__months__month")).get(Integer.parseInt(month)-1).click();
        driver.findElement(By.xpath("//abbr[text()='"+date+"']")).click();
        //driver.findElements(By.cssSelector(".react-calendar__month-view__days__day")).get(Integer.parseInt(date)).click();
        Thread.sleep(2000);
        List<WebElement> actualList = driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));
        for(int i =0;i<actualList.size();i++){
            Assert.assertEquals(actualList.get(i).getAttribute("value"),expectedList[i]);
        }
        driver.close();
        driver.quit();

    }
}
