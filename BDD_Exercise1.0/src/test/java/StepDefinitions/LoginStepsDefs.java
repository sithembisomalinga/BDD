package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginStepsDefs extends Constants {
    @Given("a user is on the home page")
    public void aUserIsOnTheHomePage() {
        // Invoke the browser and hit the url
        initializeWebDriver();
        getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        getDriver().manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        getDriver().manage().window().maximize();
    }

    @When("a user navigates to the Login page using {string}")
    public void aUserNavigatesToTheLoginPageUsing(String sUrl) {

        getDriver().get(sUrl);
    }

    @And("a user enter {string} and {string}")
    public void aUserEnterUsernameAndPassword(String sUsername, String sPassword) throws InterruptedException {
        Thread.sleep(2000);
        getDriver().findElement(By.id("username")).sendKeys(sUsername);
        getDriver().findElement(By.id("password")).sendKeys(sPassword);
    }

    @And("a user clicks the login button")
    public void aUserClicksTheLoginButton() {
        getDriver().findElement(By.id("login")).click();
    }

    @Then("a user has login successfully")
    public void aUserHasLoginSuccessfully() throws InterruptedException {
        Thread.sleep(3000);
        String welcomeMsg = getDriver().findElement(By.id("username_show")).getAttribute("value");
        System.out.println(welcomeMsg);
        if (!getDriver().findElement(By.id("username_show")).isDisplayed())
            Assert.fail();
    }


}
