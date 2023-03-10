package StepDefinitions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Report;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class LoginStepsDefs extends Constants {
    ExtentReports extent;
    ExtentTest test1;
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
        ExtentSparkReporter spark = new ExtentSparkReporter("C:\\Users\\Sithembiso.Malinga\\Desktop\\DevOps_Training\\CucumberBDD\\Reports\\report.html");
        extent = new ExtentReports();
        extent.attachReporter(spark);
        test1 = extent.createTest("Login");
        test1.log(Status.PASS, "User Fills in Login credentials");
        test1.pass("User successfully logged in");

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

        if (!getDriver().findElement(By.id("location")).isDisplayed()){
            test1.fail("Login is unsuccessful");
            Assert.fail();
        } else {
            test1.pass("Login is successful");
        }

        driver.close();
        extent.flush();

    }


}
