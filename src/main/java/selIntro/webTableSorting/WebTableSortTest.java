package selIntro.webTableSorting;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WebTableSortTest {
    public static void main(String[] args) throws InterruptedException, IOException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.findElement(By.xpath("//tr/th[1]")).click();
        List<WebElement> items = driver.findElements(By.xpath("//tr/td[1]"));
        List<String> actualList= items.stream().map(s->s.getText()).collect(Collectors.toList());
        actualList.stream().forEach(System.out::println);
        List<String> expectedList= actualList.stream().sorted().collect(Collectors.toList());
        expectedList.stream().forEach(System.out::println);
        Assert.assertTrue(actualList.equals(expectedList));

        //get the price of the Rice
        //scan the name column with getText -> Rice->print the price of rice
        List<String> price;
        do {
            List<WebElement> rows  =driver.findElements(By.xpath("//tr/td[1]"));
            price =
                    rows.stream()
                            .filter(s -> s.getText().contains("Rice"))
                            .map(s -> getPriceVeggie(s))
                            .collect(Collectors.toList());
            price.forEach(System.out::println);
            if(price.size() < 1) {
                //search in next page
                driver.findElement(By.cssSelector("[aria-label='Next']")).click();
            }
        }while(price.size() <1);
        driver.close();
        driver.quit();

    }
    private static String getPriceVeggie(WebElement element){
       return element.findElement(By.xpath("following-sibling::td[1]")).getText();
    }

}
