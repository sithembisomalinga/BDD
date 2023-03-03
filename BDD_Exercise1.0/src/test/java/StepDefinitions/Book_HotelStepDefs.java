package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Book_HotelStepDefs {

    @And("a user fill in the booking form")
    public void aUserFillInTheBookingForm() throws InterruptedException {
//      Find location and hotel
        WebElement statDropdown = Constants.getDriver().findElement(By.id("location"));
        Select dropdown = new Select(statDropdown);
        dropdown.selectByVisibleText("Sydney");

        WebElement statDropdown1 = Constants.getDriver().findElement(By.id("hotels"));
        Select dropdown1 = new Select(statDropdown1);
        dropdown1.selectByVisibleText("Hotel Creek");

//      Select the type of room and the number of rooms
        WebElement statDropdown2 = Constants.getDriver().findElement(By.id("room_type"));
        Select dropdown2 = new Select(statDropdown2);
        dropdown2.selectByVisibleText("Deluxe");

        WebElement statDropdown3 = Constants.getDriver().findElement(By.id("room_nos"));
        Select dropdown3 = new Select(statDropdown3);
        dropdown3.selectByVisibleText("One");

//      Select the arrival date and departure date
        Constants.getDriver().findElement(By.id("datepick_in")).clear();
        Constants.getDriver().findElement(By.id("datepick_in")).sendKeys("25/06/2023");
        Constants.getDriver().findElement(By.id("datepick_out")).clear();
        Constants.getDriver().findElement(By.id("datepick_out")).sendKeys("28/06/2023");

//      Select the number of adults per room and children per room
        WebElement statDropdown4 = Constants.getDriver().findElement(By.id("adult_room"));
        Select dropdown4 = new Select(statDropdown4);
        dropdown4.selectByVisibleText("Two");

        WebElement statDropdown5 = Constants.getDriver().findElement(By.id("child_room"));
        Select dropdown5 = new Select(statDropdown5);
        dropdown5.selectByVisibleText("None");

//      Submit the form, select the hotel and continue to confirmation
        Thread.sleep(1000);
        Constants.getDriver().findElement(By.id("Submit")).click();
        Thread.sleep(2000);
        Constants.getDriver().findElement(By.id("radiobutton_0")).click();
        Constants.getDriver().findElement(By.id("continue")).click();
    }

    @And("a user enters {string}, {string}, {string}, {string}, {string}")
    public void aUserEnters(String pFirstname, String pLastname, String pBill, String pCard_no, String pCvv) {
        //      Insert the names, card number and billing address
        Constants.getDriver().findElement(By.id("first_name")).sendKeys(pFirstname);
        Constants.getDriver().findElement(By.id("last_name")).sendKeys(pLastname);
        Constants.getDriver().findElement(By.id("address")).sendKeys(pBill);
        Constants.getDriver().findElement(By.id("cc_num")).sendKeys(pCard_no);

//      Select the card type, expiry month and year
        WebElement statDropdown = Constants.getDriver().findElement(By.id("cc_type"));
        Select dropdown = new Select(statDropdown);
        dropdown.selectByIndex(3);

        WebElement statDropdown1 = Constants.getDriver().findElement(By.id("cc_exp_month"));
        Select dropdown1 = new Select(statDropdown1);
        dropdown1.selectByIndex(11);

        WebElement statDropdown2 = Constants.getDriver().findElement(By.id("cc_exp_year"));
        Select dropdown2 = new Select(statDropdown2);
        dropdown2.selectByIndex(10);

//      Insert the cvv number and book the hotel
        Constants.getDriver().findElement(By.id("cc_cvv")).sendKeys(pCvv);
        Constants.getDriver().findElement(By.id("book_now")).click();
    }

    @Then("the hotel was booked successfully")
    public void theHotelWasBookedSuccessfully()  {

        WebDriverWait objWait = new WebDriverWait(Constants.getDriver(), 5);
        objWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("order_no")));

        if (!Constants.getDriver().findElement(By.id("order_no")).isDisplayed())
            Assert.fail();
        System.out.println(Constants.getDriver().findElement(By.id("order_no")).getText());
    }

    @Then("the hotel was booked unsuccessfully")
    public void theHotelWasBookedUnsuccessfully() {
    }


}
