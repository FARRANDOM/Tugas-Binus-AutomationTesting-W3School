import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Scenario1 {
    public Scenario1(){

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--guest"); // --icognito

        WebDriver driver = new ChromeDriver(options);

       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

       try {
         driver.manage().window().maximize();
         driver.get("https://www.w3schools.com/");

         WebElement searchBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tnb-google-search-input")));
         searchBar.sendKeys("Java");

         WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("tnb-google-search-submit-btn")));
         searchButton.click();
        
         WebElement JavaTut = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"___gcse_0\"]/div/div/div[1]/div[6]/div[2]/div/div/div[1]/div[1]/div/div[1]/div/a")));
         String tabAsli = driver.getWindowHandle();

         JavaTut.click();

         wait.until(ExpectedConditions.numberOfWindowsToBe(2));
            for (String handle : driver.getWindowHandles()) {
                if (!handle.equals(tabAsli)) {
                    driver.switchTo().window(handle);
                    break;
                }
            }
        WebElement Title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"main\"]/h1")));
        
         System.out.println("Result: " + Title.getText());

        } catch (TimeoutException e) {
            System.out.println("An element was not found within the specified timeout.");
        } finally {
            try {
                Thread.sleep(5000); // Wait for 5 seconds before closing the browser
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            driver.quit();
            driver.close();
        }


        
    }

    public static void main(String[] args) {
        new Scenario1();
    }
}
