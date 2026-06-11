package project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Ecom {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        driver.manage().window().maximize();
        driver.get("https://www.flipkart.com/");
        Thread.sleep(3000);        
        
        try {
            WebElement closeBtn = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.xpath("//button[contains(text(),'✕')]")
                    )
            );
            closeBtn.click();
        } catch (Exception e) {
            System.out.println("Login popup not found or already closed");
        }

        
        WebElement searchBox = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.name("q")
                )
        );
        searchBox.sendKeys("iPhone 15");
        searchBox.submit();

    
        WebElement firstProduct = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//div[contains(@data-id,'MOB')]//a")
                )
        );
        firstProduct.click();

      
        for (String windowHandle : driver.getWindowHandles()) {
            driver.switchTo().window(windowHandle);
        }

        
        WebElement addToCart = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[contains(text(),'ADD TO CART')]")));
        addToCart.click();

        System.out.println("Product added to cart successfully!");

        driver.quit();
    }
}