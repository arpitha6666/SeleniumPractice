package selIntro.handlingCerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public class HandlingHTTPSCerts {
    public static void main(String[] args) throws InterruptedException {
        FirefoxOptions options = new FirefoxOptions();
        options.setAcceptInsecureCerts(true);
        Proxy proxy = new Proxy();
        proxy.setHttpProxy("ipaddress:portnumber");
        options.setCapability("proxy",proxy);
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://expired.badssl.com/");
        System.out.println(driver.getTitle());
        driver.close();
        driver.quit();


    }
}
