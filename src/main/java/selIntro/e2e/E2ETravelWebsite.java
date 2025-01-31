package selIntro.e2e;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.Duration;

public class E2ETravelWebsite {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        Thread.sleep(1000);
        //a[@value='BLR']
        driver.findElement(By.xpath("//a[@value='DEL']")).click();
        Thread.sleep(1000);
        //below locator is not requires as when you select the 1st locator in line 17, below locator is automatically loaded
        //driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).click();
        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='MAA']")).click();
        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();
        if(driver.findElement(By.id("Div1")).getDomAttribute("style").contains("1")){
            Assert.assertTrue(false);
        }

       // driver.findElement(By.cssSelector(".ui-state-default.ui-state-active")).click();
        driver.findElement(By.id("divpaxinfo")).click();
        for(int i=0;i<4;i++) {
            driver.findElement(By.id("hrefIncAdt")).click();
        }
        driver.findElement(By.id("btnclosepaxoption")).click();
        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
        WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        Select dropdown = new Select(staticDropdown);
        dropdown.selectByIndex(3);
        System.out.println("Selected dropdownvalue by value = "+dropdown.getFirstSelectedOption().getText());
        //search button
        // driver.findElement(By.cssSelector("#ctl00_mainContent_btn_FindFlights")).click();
        driver.findElement(By.cssSelector("input[value='Search']")).click();
        // driver.findElement(By.xpath("//input[@value='Search']")).click();
        // driver.findElement(By.name("ctl00$mainContent$btn_FindFlights")).click();

        driver.close();
        driver.quit();
    }
}
