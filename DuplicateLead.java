package week2.day2.Assignments;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class DuplicateLead {
    public static void main(String[] args) throws InterruptedException {
        //Chrome Driver Set-up//
        WebDriverManager.chromedriver().setup();
        ChromeDriver chromeDriver = new ChromeDriver();
        chromeDriver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
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
        chromeDriver.findElementByXPath("//span[text()='Email']").click();
        chromeDriver.findElementByXPath("//input[@name='emailAddress']").sendKeys("veer.karri@mymail.com");
        chromeDriver.findElementByXPath("//td[@class='x-btn-center']/em/button[text()='Find Leads']").click();
        Thread.sleep(3000);
        String companyName = chromeDriver.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-companyName']/a)[1]").getText();
        chromeDriver.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-companyName']/a)[1]").click();
        chromeDriver.findElementByXPath("//a[text()='Duplicate Lead']").click();
        Assert.assertEquals("Duplicate Lead | opentaps CRM",chromeDriver.getTitle());
        chromeDriver.findElementByXPath("//input[@value='Create Lead']").click();
        String duplicateCompanyName = chromeDriver.findElementById("viewLead_companyName_sp").getText();
        String filteredDupCompName = duplicateCompanyName.replaceAll("[0-9()]","").trim();
        Assert.assertEquals(companyName,filteredDupCompName);
        chromeDriver.close();
        chromeDriver.quit();


    }
}
