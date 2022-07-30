package pl.pawelo.add1_add2.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FilterClothesPage {
    private WebDriver driver;

    public FilterClothesPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "//*[@id=\"js-product-list\"]/div[1]/article[2]/div/a/img")
    private WebElement clickHPSweater;

    public void  chooseHPSweater() {clickHPSweater.click();}
}