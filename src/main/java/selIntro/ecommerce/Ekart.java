package selIntro.ecommerce;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class Ekart {
    public static void main(String[] args) throws InterruptedException {
        String[] veggies = {"Cucumber", "Brocolli", "Beetroot"}; //takes less memory
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        Thread.sleep(3000);
        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
        //check whether veggies are present in products list
        //convert veggies[] into arrayList
        List<String> veggiList = Arrays.asList(veggies);
        int j = 0;
        for(int i =0;i< products.size(); i++) {
            if (veggiList.contains(products.get(i).getText().split("-")[0].trim())) {
                //click on add to Cart
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
                System.out.println("clicked");
                if (j == veggies.length) {
                    break;
                }
            }
        }
//        driver.close();
//        driver.quit();
    }
}


//
