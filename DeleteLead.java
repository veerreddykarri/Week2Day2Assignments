package week2.day2.Assignments;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class DeleteLead {
    public static void main(String[] args) throws InterruptedException {
        //Chrome Driver Set-up//
        WebDriverManager.chromedriver().setup();
        ChromeDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("http://leaftaps.com/opentaps/control/main");
        //Login Page//
        chromeDriver.findElementByXPath("//input[@id='username']").sendKeys("demosalesmanager");
        WebElement password = chromeDriver.findElementById("password");
        password.clear();
        password.sendKeys("crmsfa");
        chromeDriver.findElementByClassName("decorativeSubmit").click();
        chromeDriver.findElementByLinkText("CRM/SFA").click();
        chromeDriver.findElementByLinkText("Leads").click();
        chromeDriver.findElementByLinkText("Find Leads").click();
        chromeDriver.findElementByXPath("//span[text()='Phone']").click();
        chromeDriver.findElementByXPath("//input[@name='phoneCountryCode']").clear();
        chromeDriver.findElementByXPath("//input[@name='phoneCountryCode']").sendKeys("12");
        chromeDriver.findElementByXPath("//input[@name='phoneAreaCode']").sendKeys("123");
        chromeDriver.findElementByXPath("//input[@name='phoneNumber']").sendKeys("1234");
        chromeDriver.findElementByLinkText("Find Leads").click();
        Thread.sleep(3000);
        chromeDriver.findElementByXPath("(//*[@class='x-grid3-row-table']//div[@unselectable='on']/a[contains(@id, 'ext')])[1]").click();

    }
}
