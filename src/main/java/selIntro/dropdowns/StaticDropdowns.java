package selIntro.dropdowns;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class StaticDropdowns {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        //static dropdown -> when you see 'Select' tag
        Select dropdown = new Select(staticDropdown);
        dropdown.selectByIndex(3);
        //to check if the dropdown value is selected - call method
        String selectedValue =dropdown.getFirstSelectedOption().getText();
        System.out.println("Selected dropdownvalue by index = "+selectedValue);
        //to select the value by visible text
        dropdown.selectByVisibleText("AED");
        System.out.println("Selected dropdownvalue by visibletext = "+dropdown.getFirstSelectedOption().getText());
        //to select the value by value , you have to check the html value attribute ,
        // in this case both attribute value and text value displayed are same
        dropdown.selectByValue("INR");
        System.out.println("Selected dropdownvalue by value = "+dropdown.getFirstSelectedOption().getText());
        driver.close();
        driver.quit();
    }
}
