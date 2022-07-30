package pl.pawelo.add1_add2.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

    private WebDriver driver;

    public ProductPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "group_1")
    private WebElement sizeBtn;

    @FindBy(xpath = "//*[@id=\"group_1\"]/option[2]")
    private WebElement selectSize;

    @FindBy(id = "quantity_wanted")
    private WebElement quantityTextField;

    @FindBy(className = "add-to-cart")
    private WebElement addCartBtn;

    @FindBy(xpath = "//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/div/a")
    private WebElement confirmAddCartBtn;

    public void selectAtribute() {
        sizeBtn.click();
        selectSize.click();
        quantityTextField.clear();
        quantityTextField.sendKeys("5");
    }

    @FindBy (css = "button[class='btn btn-primary add-to-cart']")
    private WebElement addCartProduct;

    public void addCart () {
        addCartProduct.click();
    }

    @FindBy (xpath = "//*[contains(text(),'Proceed to checkout')]")
    private WebElement proceedToBasket;

    public void btnProceedToBasket (){
        proceedToBasket.click();
    }
}
