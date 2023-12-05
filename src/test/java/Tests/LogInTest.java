package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogInTest {

    public WebDriver driver;

    @Test
    public void metodatest(){
     driver =  new ChromeDriver();
     driver.get("https://demo.automationtesting.in/Index.html");
     driver.manage().window().maximize();

        WebElement SignIn_Element = driver.findElement(By.id("btn1"));
        SignIn_Element.click();

        WebElement emailElement = driver.findElement(By.cssSelector("input[placeholder='E mail']"));
        String emailValue="alexdorha";
        emailElement.sendKeys(emailValue); // declaratie element, apoi identificare element

        WebElement passwordElement = driver.findElement(By.cssSelector("input[placeholder='Password']"));
        String passValue = "12345";
        passwordElement.sendKeys(passValue);

        WebElement enterElement = driver.findElement(By.id("enterbtn"));
        enterElement.click();
        WebElement errorElement = driver.findElement(By.id("errormsg"));
        String expected_error="Invalid User Name or PassWord";
        String actual_error = errorElement.getText();
        Assert.assertEquals(actual_error,expected_error);

    }
}
