package week2.day2.Assignments;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class PracticeXpath {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://leaftaps.com/opentaps/control/login");
        driver.findElementByXPath("//label[text()='Username']/following-sibling::input").sendKeys("demosalesmanager");
        driver.findElementByXPath("//label[text()='Password']/following-sibling::input").sendKeys("crmsfa");
        driver.findElementByXPath("//input[@class='decorativeSubmit']").click();
        driver.findElementByXPath("//a[contains(text(),'CRM/SFA')]").click();
        driver.findElementByXPath("//div[@class='x-panel-header']/a[text()='Leads']").click();
        driver.findElementByXPath("//a[text()='Merge Leads']").click();
        driver.findElementByXPath("(//img[@alt='Lookup'])[1]").click();
        Set<String> handler =driver.getWindowHandles();
        Iterator<String> iterator =handler.iterator();
        String parentWindow = iterator.next();
        System.out.println("Parent window id is :"+parentWindow);
        String childWindow = iterator.next();
        System.out.println("Child window id is :"+childWindow);
        driver.switchTo().window(childWindow);
        driver.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]").click();
        driver.switchTo().window(parentWindow);
        driver.findElementByXPath("(//img[@alt='Lookup'])[2]").click();
        Thread.sleep(5000);
        driver.switchTo().window(childWindow);
        driver.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[2]").click();
        driver.switchTo().window(parentWindow);
        driver.findElementByXPath("//a[@class='buttonDangerous']").click();
        driver.switchTo().alert().accept();
        String companyName =driver.findElementByXPath("//span[@id='viewLead_companyName_sp']").getText();
        System.out.println(companyName);
        driver.close();
        driver.quit();

    }
}
