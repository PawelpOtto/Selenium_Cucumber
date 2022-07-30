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

import java.awt.*;
import java.io.IOException;
import java.time.Duration;


public class Task2_OrderSteps {

    private WebDriver driver;
    private YourOrderIsConfirmedPage yourOrderIsConfirmedPage;

    @Given("User goes to main")
    public void UserGoesToMain() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.get("https://mystore-testlab.coderslab.pl/index.php");
    }

    @When("User sign in")
    public void iSignIn() {
        MainPage mainPage = new MainPage(driver);
        mainPage.signIn();
    }


    @Then("User login by {string} and {string}")
    public void iLoginByEmailAndPasswd(String email, String passwd) {
        SignInPage signInPage = new SignInPage(driver);
        signInPage.logInData(email, passwd);
    }

    @When("User clicks clothes and choose Hummingbird Printed Sweater")
    public void iClickClothesAndIChooseHummingbirdPrintedSweater() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clothes();

        FilterClothesPage filterClothesPage = new FilterClothesPage(driver);
        filterClothesPage.chooseHPSweater();
    }

    @And("User checks the discount {string}")
    public void iCheckDiscount(String discount) {
        String alertDiscount = driver.findElement(By.cssSelector("span[class='discount discount-percentage']")).getText();
        Assert.assertEquals(discount, alertDiscount);
    }

    @And("User chooses {string} size and quantity {string} and I add item to cart")
    public void iChooseSizeAndQuantityAndIAddItemToCart(String size, String qty) {
        ProductPage productPage = new ProductPage(driver);
        productPage.selectAtribute();
        productPage.addCart();
        productPage.btnProceedToBasket();
    }

    @Then("User confirms and orders")
    public void iCheckoutAndConfirmBasket() {

        MyOrderPage myOrderPage = new MyOrderPage(driver);
        myOrderPage.btnProceedBasket();
    }

    @When("User confirms address")
    public void iConfirmAddress() {
        String addressIsVisible = driver.findElement(By.xpath("//span[@class='address-alias h4']")).getText();
        Assert.assertEquals("Lolo", addressIsVisible);
        driver.findElement(By.xpath("//button[@name='confirm-addresses']")).click();
    }

    @And("User chooses PrestaShop and Pay by check")
    public void iChoosePrestaShopAndPayByCheck() {
        ConfirmOrderDataPage confirmOrderDataPage = new ConfirmOrderDataPage(driver);

        confirmOrderDataPage.PrestaShop();
        confirmOrderDataPage.shippingContinueButton();

        confirmOrderDataPage.choosePaymentMethod();
        confirmOrderDataPage.agreedTermsAndServices();
        confirmOrderDataPage.orderObligationToPay();
    }

    @Then("User takes screenshot")
    public void iTakeScreenshot() throws IOException, AWTException, InterruptedException {
        YourOrderIsConfirmedPage yourOrderIsConfirmedPage = new YourOrderIsConfirmedPage(driver);
        yourOrderIsConfirmedPage.TakeScreenshot();
    }





    @And("User closes browser")
    public void iCloseBrowser() {
        driver.close();
    }
}

