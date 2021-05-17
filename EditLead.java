package week2.day2.Assignments;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class EditLead {
    public static void main(String[] args) throws InterruptedException {
        //Chrome Driver Set-up//
        WebDriverManager.chromedriver().setup();
        ChromeDriver chromeDriver = new ChromeDriver();
        chromeDriver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        chromeDriver.manage().window().maximize();
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
        chromeDriver.findElementByXPath("(//div[@class='x-form-element']/input[@name='firstName'])[3]").sendKeys("Veer");
        chromeDriver.findElementByXPath("//td[@class='x-btn-center']/em/button[text()='Find Leads']").click();
        Thread.sleep(3000);
        chromeDriver.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]").click();
        Thread.sleep(2000);
        Assert.assertEquals("View Lead | opentaps CRM",chromeDriver.getTitle());
        chromeDriver.findElementByLinkText("Edit").click();
        String newCompanyName = "Border Agency";
        chromeDriver.findElementById("updateLeadForm_companyName").clear();
        chromeDriver.findElementById("updateLeadForm_companyName").sendKeys(newCompanyName);
        chromeDriver.findElementByXPath("//input[@value='Update']").click();
        String updatedCompanyName =chromeDriver.findElementById("viewLead_companyName_sp").getText();
        String filteredCompanyName = updatedCompanyName.replaceAll("[0-9()]","").trim();
        Assert.assertEquals(newCompanyName,filteredCompanyName);
        chromeDriver.close();
        chromeDriver.quit();


    }
}
