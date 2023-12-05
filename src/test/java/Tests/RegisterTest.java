package Tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import javax.swing.*;
import java.time.Year;
import java.util.List;

public class RegisterTest {

 public WebDriver driver;

 @Test
 public void metodatest(){

  ChromeOptions options = new ChromeOptions();
  options.addArguments("--window-size=1920,1080");
  driver = new ChromeDriver(options);


   driver.get("https://demo.automationtesting.in/Index.html");
   // driver.manage().window().maximize();


   WebElement SkipSignIn = driver.findElement(By.id("btn2"));
   SkipSignIn.click();


   WebElement Consent = driver.findElement(By.xpath("//p[text()='Consent']"));
   Consent.click();


   WebElement first_name = driver.findElement(By.cssSelector("input[placeholder = 'First Name']"));
   String first_name_value = "Anca";
   first_name.sendKeys(first_name_value);

   WebElement last_name = driver.findElement(By.cssSelector("input[placeholder = 'Last Name']"));
   String last_name_value = "Gherghisan";
   last_name.sendKeys(last_name_value);

   WebElement adress = driver.findElement(By.cssSelector("textarea[ng-model]"));
   String adress_value = "Aleaa Parcului, nr. 10";
   adress.sendKeys(adress_value);

   WebElement email = driver.findElement(By.cssSelector("input[ng-model='EmailAdress']"));
   String email_value = "anca.gherghisan@yahoo.com";
   email.sendKeys(email_value);

  WebElement phone = driver.findElement(By.cssSelector("input[ng-model='Phone']"));
  String phone_number = "0720100200";
  phone.sendKeys(phone_number);

   WebElement Gender = driver.findElement(By.xpath("//input[@value='FeMale']"));
   Gender.click();

   WebElement hobbies_2 = driver.findElement(By.id("checkbox2"));
   hobbies_2.click();

   JavascriptExecutor js = (JavascriptExecutor) driver;
   js.executeScript("window.scrollBy(0,450)", "");

//  try {
//   Thread.sleep(3500);
//  } catch (InterruptedException e) {
//   System.out.println(e.getMessage());
//  }

   WebElement languages = driver.findElement(By.id("msdd"));
   // js.executeScript("arguments[0].scrollIntoView(true);",languages);
   languages.click();

   String expected_language = "English";
   String expected_language2 = "Turkish";

           //definim o lista de elemente:

  //driver.findElement(By.xpath("//html")).click();


  List<WebElement> language_options = driver.findElements(By.cssSelector(".ui-corner-all"));
   for (Integer index = 0; index < language_options.size(); index++){
   if(language_options.get(index).getText().equals(expected_language) ||
           (language_options.get(index).getText().equals(expected_language2))){
      language_options.get(index).click();
   }
  }


   WebElement Skills = driver.findElement(By.id("Skills"));
   Select SkillDropDown = new Select(Skills); //obiect tip select
   SkillDropDown.selectByVisibleText("AutoCAD");


   WebElement Year =driver.findElement(By.id("yearbox"));
   Select YearDropDown = new Select(Year);
   YearDropDown.selectByValue("1987");


   WebElement Month =driver.findElement(By.xpath("//select[@placeholder='Month']"));
   Select MonthDropdown = new Select(Month);
   MonthDropdown.selectByValue("February");


  }
 }

