package logintest;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class LoginTestAutomation {
    public static WebDriver driver = null;

        @Test
        public void successfulLoginTest() throws InterruptedException {

            System.out.println("Successful login test to be executed...");
                        System.setProperty("webdriver.chrome.driver", "D://VLad//Selenium Jars and Drivers//Drivers//chromedriver/chromedriver.exe");
                        WebDriver driver = new ChromeDriver();
                        driver.get("https://www.saucedemo.com/");
                        driver.manage().window().maximize();

                        driver.findElement(By.id("user-name")).sendKeys("standard_user");
                        driver.findElement(By.name("password")).sendKeys("secret_sauce");
                        driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();

                        Thread.sleep(2000);
                       String actualUrl = "https://www.saucedemo.com/inventory.html";
                       String expectedUrl = driver.getCurrentUrl();
                       Assert.assertEquals(expectedUrl, actualUrl);


                        WebElement menuButton = driver.findElement(By.cssSelector("#menu_button_container > div > div:nth-child(1) > div"));
                        Assert.assertTrue(menuButton.isDisplayed());
                        System.out.println("Test is successfully completed !");
        }
                        @Test
    public void wrongPasswordTest () {
                            System.out.println("Wrong password test to be executed...");
                            //System.setProperty("webdriver.chrome.driver", "D://VLad//Selenium Jars and Drivers//Drivers//chromedriver/chromedriver.exe");
                            WebDriver driver = new ChromeDriver();
                            driver.get("https://www.saucedemo.com/");
                            driver.manage().window().maximize();


                            driver.findElement(By.id("user-name")).sendKeys("standard_user");
                            driver.findElement(By.name("password")).sendKeys("wrong_password");
                            driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();

                            String actualUrl = "https://www.saucedemo.com/";
                            String expectedUrl = driver.getCurrentUrl();
                            Assert.assertEquals(expectedUrl, actualUrl);


                            WebElement errorMessage = driver.findElement(By.cssSelector("#login_button_container > div > form > div.error-message-container.error"));
                            Assert.assertTrue(errorMessage.isDisplayed());
                            System.out.println("Test is successfully completed !");
                        }
                }


