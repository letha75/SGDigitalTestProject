package Steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class CareerSearch {
    WebDriver driver ;
    public CareerSearch()
    {
        System.setProperty("webdriver.chrome.driver", "c://driver//chromedriver.exe");
        //initialize chrome driver instance
        driver = new ChromeDriver();
    }
    @Given("^User launch SGDigital homepage$")
    public void userLaunchSGDigitalHomepage()
    {
        //start a new chrome browser
        driver.get("https://www.sgdigital.com");
        driver.manage().window().maximize();
    }
    @Then("^Careers menu item is displayed$")
    public void careersMenuItemIsDisplayed()
    {
        boolean blLinkPresent=driver.findElement(By.linkText("Careers")).isDisplayed();
        if(blLinkPresent == true)
        {
            System.out.println("Careers link is available in SGDigital home Page.");
        }
        else
            {
            System.out.println("Careers link is not available in SGDigital home page.");
            }

    }

    @When("^User clicks on Careers link$")
    public void userClicksOnCareersLink()
    {
        driver.findElement(By.linkText("Careers")).click();
        System.out.println("\nUser clicked on Careers Link");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Then("^Careers Page is displayed with current vacancies listed$")
    public void careersPageIsDisplayedWithCurrentVacanciesListed()
    {
        boolean blVacancyCount=driver.findElement(By.className("srJobListJobTitle")).isDisplayed();
        if(blVacancyCount == true)
        {
            System.out.println("\nCurrent Vacancies are displayed.");
        }
        else
        {
            System.out.println("Current Vacancies are not displayed..");
        }
    }

    @And("^User enters valid keyword as Analyst$")
    public void userEntersValidKeywordAsAnalyst()
    {
        driver.findElement(By.className("srSearchInput")).sendKeys("Analyst");

    }

    @And("^I click enter key$")
    public void iClickEnterKey()
    {
        driver.findElement(By.className("srSearchInput")).sendKeys(Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    @Then("^Vacancies based on the criteria is displayed$")
    public void vacanciesBasedOnTheCriteriaIsDisplayed()
    {

    }

    @And("^user selects location as Singapore$")
    public void userSelectsLocationAsSingapore ()
    {
        WebElement dropdown=driver.findElement(By.className("srSearchOption"));
        dropdown.click();
        String locValue ="Singapore";
        List<WebElement> options=dropdown.findElements(By.className("srSearchOptionListElement"));
        for (WebElement option :options)
            {
             if (option.getText().equals(locValue))
             {
                 option.click();
                 break;
             }
            }
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }

    @Then("^vacancies specific to location is displayed$")
    public void vacanciesSpecificToLocationIsDisplayed ()
    {

    }

    @And("^User enters special character keyword as c\\$$")
    public void userEntersSpecialCharacterKeywordAsC$()
    {
        driver.findElement(By.className("srSearchInput")).sendKeys("c$");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Then("^Close Browser$")
    public void closeBrowser()
    {
        //Close Browser
        driver.quit();
    }

    @And("^User enters non existing keyword as \"([^\"]*)\"$")
    public void userEntersNonExistingKeywordAs(String arg0) throws Throwable
    {
        driver.findElement(By.className("srSearchInput")).sendKeys(arg0);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
}