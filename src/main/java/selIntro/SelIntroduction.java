package selIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SelIntroduction {

    public static void main(String[] args){
        //System.setProperty("webdriver.gecko.driver","C:/Users/arpit/Downloads/Firefox Installer.exe");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://rahulshettyacademy.com");
        System.out.println("Title "+driver.getTitle());
        System.out.println("URL "+driver.getCurrentUrl());
        driver.close();
        driver.quit();
    }

}
