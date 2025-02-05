package selIntro.miscellaniousTopics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class CountLinks {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        System.out.println("Links on the whole page "+ driver.findElements(By.tagName("a")).size());
        //limiting webdriver scope
        WebElement footerDriver =driver.findElement(By.id("gf-BIG"));
        System.out.println("Links in the footer "+footerDriver.findElements(By.tagName("a")).size());
        //count the link in the footer -1st column
        WebElement columnFootDriver =driver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
        System.out.println("Links in the columnFooter "+columnFootDriver.findElements(By.tagName("a")).size());
        //click on each link in the column and check if pages are opening
        int count =columnFootDriver.findElements(By.tagName("a")).size();
        for(int i =1;i<count; i++) {
            String clickOnLinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
            columnFootDriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnLinkTab);
            Thread.sleep(5000);
        }
            Set<String> titleSet =driver.getWindowHandles();
            Iterator itr = titleSet.iterator();
            while(itr.hasNext()){
                driver.switchTo().window(String.valueOf(itr.next()));
                System.out.println("Title : "+driver.getTitle());


        }
        driver.close();
        driver.quit();
    }
}
