package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {
    private WebDriver driver;
    private String baseUrl;
    private Waiter waiter;

    public Driver() {
        this.driver = new ChromeDriver();
        this.waiter = new Waiter(this.driver);
        this.baseUrl = "https://jira-auto.codecool.metastage.net/secure/Dashboard.jspa";
        this.waiter.waitForPageToLoadCompletely();
        this.waiter.waitCertainAmountOfTime(20);
        driver.manage().window().maximize();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void close(){
        driver.close();
    }

    public String getProjectURL (String projectId) {
        return "https://jira-auto.codecool.metastage.net/projects/" + projectId + "/issues";
    }

    public void navigation (String url) {
        this.waiter.waitCertainAmountOfTime(1000000);
        driver.get(url);
    }

    public void acceptAlert () {
        driver.switchTo().alert().accept();
    }
}
