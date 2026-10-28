import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Scenario3 {
    public Scenario3(){

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--guest"); // --icognito

        WebDriver driver = new ChromeDriver(options);

       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

       try {
         driver.manage().window().maximize();
         driver.get("https://www.w3schools.com/");

         WebElement JavaTut = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"subtopnav\"]/a[6]")));
         JavaTut.click();

         Actions action = new Actions(driver);
         action.scrollToElement(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"main\"]/div[6]/p/a")))).perform();

         WebElement TryItYourself = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"main\"]/div[6]/p/a")));
         String tabAsli = driver.getWindowHandle();
         TryItYourself.click();

         wait.until(ExpectedConditions.numberOfWindowsToBe(2));
            for (String handle : driver.getWindowHandles()) {
                if (!handle.equals(tabAsli)) {
                    driver.switchTo().window(handle);
                    break;
                }
            }
        
            WebElement RunBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"runbtn\"]")));
            RunBtn.click();
            
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("iframeResult")));

            WebElement Result = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/pre")));
            System.out.println("Result: " + Result.getText());

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
        new Scenario3();
    }
}
