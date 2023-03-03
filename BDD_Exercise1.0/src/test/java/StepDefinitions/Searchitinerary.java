package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class Searchitinerary {
    @And("a user clicks on search hotel link")
    public void aUserClicksOnSearchHotelLink() {


        Actions a = new Actions(Constants.getDriver());
        Constants.getDriver().findElement(By.id("order_no")).click();
        a.keyDown(Keys.CONTROL);
        a.keyDown("a");
        a.keyUp(Keys.CONTROL);
        a.build().perform();

        a.keyDown(Keys.CONTROL);
        a.keyDown("c");
        a.keyUp(Keys.CONTROL);
        a.build().perform();

        Constants.getDriver().findElement(By.id("my_itinerary")).click();

        Constants.getDriver().findElement(By.id("order_id_text")).click();
        a.keyDown(Keys.CONTROL);
        a.keyDown("v");
        a.keyUp(Keys.CONTROL);
        a.build().perform();
    }

    @And("a user enter order number and click on the go button")
    public void aUserEnterOrderNumberAndClickOnTheGoButton() {
        Constants.getDriver().findElement(By.id("search_hotel_id")).click();
    }

    @Then("the search is successful")
    public void theSearchIsSuccessful() {
        if(!Constants.getDriver().findElement(By.id("search_result_error")).isDisplayed())
            Assert.fail();

        Constants.getDriver().findElement(By.id("logout")).click();
    }
}
