    package selIntro.assignments;

    import io.github.bonigarcia.wdm.WebDriverManager;
    import org.openqa.selenium.By;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.WebElement;
    import org.openqa.selenium.firefox.FirefoxDriver;
    import org.openqa.selenium.support.ui.Select;
    import org.testng.Assert;

    import java.time.Duration;

    public class Assignment6 {

        public static void main(String[] args) throws InterruptedException {
            WebDriverManager.firefoxdriver().setup();
            WebDriver driver = new FirefoxDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.get("https://rahulshettyacademy.com/AutomationPractice/");
            //select any checkbox and get the label text of the checkbox
            driver.findElement(By.xpath("//*[@id='checkbox-example']/fieldset/label[1]/input")).click();
            String refElement=driver.findElement(By.xpath("//*[@id='checkbox-example']/fieldset/label[1]")).getText();
            System.out.println("refElement "+refElement);
            //select the refElement from the dropdown
            WebElement drpDown = driver.findElement(By.id("dropdown-class-example"));
            Select dropdownSelect = new Select(drpDown);
            dropdownSelect.selectByVisibleText(refElement);
            //enter refElement in the "enter-name"
            driver.findElement(By.name("enter-name")).sendKeys(refElement);
            driver.findElement(By.id("alertbtn")).click();
            driver.switchTo().alert();
            Assert.assertTrue(driver.switchTo().alert().getText().contains(refElement));
            driver.switchTo().alert().accept();
            driver.close();
            driver.quit();


        }
    }
