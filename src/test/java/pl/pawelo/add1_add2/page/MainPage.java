package pl.pawelo.add1_add2.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    private WebDriver driver;

    public MainPage (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "//*[@id=\"_desktop_user_info\"]/div/a")
    private WebElement btn;

    public void signIn(){
        btn.click();
    }

    @FindBy (xpath = "//*[@id=\"category-3\"]/a")
    private WebElement clothesfilter;

    public void  clothes() {clothesfilter.click();}

    @FindBy (xpath = "//span[contains(text(),'Lolo Name')]")
    private WebElement setGoMyAccount;

    public void goMyAccount (){setGoMyAccount.click();}
}