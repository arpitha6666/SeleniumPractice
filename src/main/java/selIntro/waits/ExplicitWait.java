package selIntro.waits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class ExplicitWait {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        WebDriverWait w = new WebDriverWait(driver, 5);
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        String[] veggies = {"Cucumber", "Brocolli", "Beetroot"}; //takes less memory
        addItems(driver,veggies);
        driver.findElement(By.cssSelector("img[alt='Cart']")).click();
        w.until(ExpectedConditions.visibilityOfElementLocated(By.id("//button[text()='PROCEED TO CHECKOUT']")));
        driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
        driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
        driver.findElement(By.cssSelector("button.promoBtn")).click();
        //explicit wait
        w.until(ExpectedConditions.visibilityOfElementLocated(By.id("span.promoInfo")));
        Assert.assertEquals(driver.findElement(By.cssSelector("span.promoInfo")).getText(), "Code applied ..!");
        Thread.sleep(2000);

    }
    public static void addItems(WebDriver driver, String[] itemsNeeded) {
        List<String> veggiList = Arrays.asList(itemsNeeded);
        int j = 0;
        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
        for (int i = 0; i < products.size(); i++) {
            if (veggiList.contains(products.get(i).getText().split("-")[0].trim())) {
                //click on add to Cart
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
                System.out.println("clicked");
                if (j == itemsNeeded.length) {
                    break;
                }
            }
        }
    }
}
