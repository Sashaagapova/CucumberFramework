package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class EtsyHomePage {
    WebDriver driver;

    public EtsyHomePage(){
        this.driver= Driver.driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy (id="global-enhancements-search-query")
    public WebElement searchBox;


    @FindBy(css = ".wt-badge.wt-badge--small.wt-badge--sale-01")
    public WebElement freeShippingLabel;

    @FindBy(xpath="//h2[@class='text-gray text-truncate mb-xs-0 text-body']")
    public WebElement item;

    @FindBy(id="catnav-primary-link-10855")
    public WebElement JewelryAc;

    @FindBy(id="catnav-primary-link-10923")
    public WebElement clothesS;

    @FindBy(id="catnav-primary-link-891")
    public WebElement homeL;

    @FindBy(id="catnav-primary-link-10983")
    public WebElement weddingP;

    @FindBy(id="catnav-primary-link-11049")
    public WebElement toysE;


}
