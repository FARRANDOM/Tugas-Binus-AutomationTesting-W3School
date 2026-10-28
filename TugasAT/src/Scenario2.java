import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Scenario2 {
    public Scenario2(){

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--guest"); // --icognito

        WebDriver driver = new ChromeDriver(options);

       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

       try {
         driver.manage().window().maximize();
         driver.get("https://www.w3schools.com/");

         WebElement searchBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tnb-google-search-input")));
         searchBar.sendKeys("Johnny Depp");

         WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("tnb-google-search-submit-btn")));
         searchButton.click();

         WebElement ErrorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"___gcse_0\"]/div/div/div[1]/div[6]/div[2]/div/div/div[3]/div[1]/div/div")));
         System.out.println("Result: " + ErrorMessage.getText());

        } catch (TimeoutException e) {
            System.out.println("Result : No tutorial with that name found" );
        } finally {
            try {
                Thread.sleep(2000); // Wait for 2 seconds before closing the browser
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            driver.quit();
            driver.close();
        }
    }

        public static void main(String[] args) {
            new Scenario2();
        }
}
