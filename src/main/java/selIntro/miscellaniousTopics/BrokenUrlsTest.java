package selIntro.miscellaniousTopics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.hc.core5.http.HttpConnection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class BrokenUrlsTest {
    public static void main(String[] args) throws InterruptedException, IOException {
        SoftAssert sa = new SoftAssert();
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        //find the links in the page
        List<WebElement> urlList= driver.findElements(By.cssSelector("li[class='gf-li'] a"));
        for(WebElement link : urlList) {
            HttpURLConnection conn = (HttpURLConnection) new URL(link.getAttribute("href")).openConnection();
            conn.setRequestMethod("HEAD");
            conn.connect();
            sa.assertTrue(conn.getResponseCode() < 400, "Link broken : " + link.getAttribute("href") + " with status code : " + conn.getResponseCode());
        }
        sa.assertAll();
        driver.close();
        driver.quit();
    }

}
