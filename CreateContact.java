package week2.day2.Assignments;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class CreateContact {
    public static void main(String[] args) {
        //Chrome Driver Set-up//
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        //Implicit Wait//
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Loading URL and Login Page//
        driver.get("http://leaftaps.com/opentaps/control/login");
        driver.findElementById("username").sendKeys("demosalesmanager");
        driver.findElementById("password").sendKeys("crmsfa");
        driver.findElementByClassName("decorativeSubmit").click();
        //Landing Page//
        driver.findElementByLinkText("CRM/SFA").click();
        //Home Page > Click Contact
        driver.findElementByLinkText("Contacts").click();
        driver.findElementByLinkText("Create Contact").click();
        //Create Contact//
        driver.findElementById("firstNameField").sendKeys("Veer");
        driver.findElementById("lastNameField").sendKeys("Karri");
        driver.findElementById("createContactForm_firstNameLocal").sendKeys("Veer");
        driver.findElementById("createContactForm_lastNameLocal").sendKeys("Karri");
        driver.findElementById("createContactForm_personalTitle").sendKeys("Sir");
        driver.findElementById("createContactForm_birthDate").sendKeys("01/01/86");
        driver.findElementById("createContactForm_generalProfTitle").sendKeys("Mr");
        driver.findElementById("createContactForm_departmentName").sendKeys("CTC");
        driver.findElementById("createContactForm_description").sendKeys("Veer added some description");
        driver.findElementById("createContactForm_importantNote").sendKeys("Veer Added some important note");
        //Contact Information//
        driver.findElementById("createContactForm_primaryPhoneCountryCode").clear();
        driver.findElementById("createContactForm_primaryPhoneCountryCode").sendKeys("+1");
        driver.findElementById("createContactForm_primaryPhoneAreaCode").sendKeys("1234");
        driver.findElementById("createContactForm_primaryPhoneNumber").sendKeys("56789");
        driver.findElementById("createContactForm_primaryPhoneExtension").sendKeys("234");
        driver.findElementById("createContactForm_primaryPhoneAskForName").sendKeys("Veer");
        driver.findElementByXPath("//input[@id='createContactForm_primaryEmail']").sendKeys("veer.karri@ctc.com");
        //Primary Address//
        driver.findElementById("createContactForm_generalAttnName").sendKeys("Veer");
        driver.findElementById("createContactForm_generalAddress1").sendKeys("Chetwode Close");
        driver.findElementById("createContactForm_generalAddress2").sendKeys("Tennise");
        driver.findElementById("createContactForm_generalCity").sendKeys("New York");
        WebElement stateDropdown =driver.findElementById("createContactForm_generalStateProvinceGeoId");
        Select state = new Select(stateDropdown);
        state.selectByVisibleText("New York");
        driver.findElementById("createContactForm_generalPostalCode").sendKeys("12345");
        driver.findElementById("createContactForm_generalPostalCodeExt").sendKeys("12");
        driver.findElementByXPath("//input[@class='smallSubmit']").click();
        driver.findElementByLinkText("Edit").click();
        driver.findElementById("updateContactForm_description").clear();
        driver.findElementById("updateContactForm_importantNote").sendKeys("Veer updated the important information");
        driver.findElementByXPath("//input[@class='smallSubmit']").click();
        System.out.println(driver.getTitle());
        driver.close();
        driver.quit();
    }
}
