package pl.pawelo.add1_add2;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.pawelo.add1_add2.page.*;

import java.time.Duration;

public class Task1_AddAddressSteps {

    private WebDriver driver;

    @Given("User goes to main page")
    public void UserGoesToMainPage() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://mystore-testlab.coderslab.pl/index.php");
    }

    @When("user goes to the login page")
    public void UserGoesToTheLoginPage() {
        MainPage mainPage = new MainPage(driver);
        mainPage.signIn();
    }


    @Then("User login using {string} and {string}")
    public void UserLoginUsingEmailAndPasswd(String email, String passwd) {
        SignInPage signInPage = new SignInPage(driver);
        signInPage.logInData(email, passwd);
    }


    @And("User goes to my {string} page at my account page on url {string}")
    public void UserGoesToMyAccountPage(String page, String url) {
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        myAccountPage.createAddress(page, url);
    }

    @And("user adds a new address")
    public void UserAddsNewAddress() {
        MyAddressPage myAddressPage = new MyAddressPage(driver);
        myAddressPage.setAddAddressBtn();
    }

    @And("^User enters a new alias (.+) address (.+) city (.+) postal (.+) country (.+) phone (.+)$")
    public void UserEntersNewData(String alias, String address, String city, String postal, String country, String phone) {
        CreateAddress createAddress = new CreateAddress(driver);
        createAddress.enterDataAddress(alias, address, city, postal, country, phone);
    }

    @Then("^User verify created alias (.+) address (.+) city (.+) postal (.+) country (.+) phone (.+)$")
    public void UserVerifyCreatedAddress(String alias, String address, String city, String postal, String country, String phone) {


        String actualAddress = driver.findElement(By.cssSelector(".address-body")).getText();
        String nameSurname = "Lolo" + " " + "Name";
        String expectedAddress = String.join("\n", alias, nameSurname, address, city, postal, country, phone);
        Assert.assertEquals(expectedAddress, actualAddress);
    }

    @When("User deletes the address")
    public void UserDeletesTheAddress() {
        RemoveMyAddressPage removeAddressPage = new RemoveMyAddressPage(driver);
        removeAddressPage.clickRemoveAddressBtn();
    }

    @Then("User can see message that address was removed with text {string}")
    public void UserCanSeeMessageThatAddressWasRemovedWithText(String message) {
        String alertMessage = driver.findElement(By.cssSelector("article[data-alert='success']")).getText();
        Assert.assertEquals(message, alertMessage);
    }


    @And("User closes shop page")
    public void UserClosesShopPage()  {
        driver.quit();
    }
}
