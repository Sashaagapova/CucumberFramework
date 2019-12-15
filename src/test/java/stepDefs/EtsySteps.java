package stepDefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.EtsyHomePage;
import pages.EtsyResultPage;
import utilities.BrowserUtils;
import utilities.Configuration;
import utilities.Driver;

import java.util.List;
import java.util.Set;

public class EtsySteps {

    EtsyHomePage etsyHomePage= new EtsyHomePage();
    EtsyResultPage etsyResultPage= new EtsyResultPage();

    @Given("^Navigate Etsy Homepage$")
    public void navigate_Etsy_Homepage() throws Throwable {
        Driver.driver.get(Configuration.getProperties("etsyUrl"));
    }

    @When("^User searches for \"([^\"]*)\"$")
    public void user_searches_for(String item) throws Throwable {
    etsyHomePage.searchBox.sendKeys(item+ Keys.ENTER);

    }

    @Then("^Validate search message have word \"([^\"]*)\"$")
    public void validate_search_message_have_word(String item) throws Throwable {
    String actualSearchmessage=etsyResultPage.searchMessage.getText();
        Assert.assertEquals(item,actualSearchmessage);
        Thread.sleep(2000);
    }

//    @When("^User clicks on \"([^\"]*)\"$")
//    public void user_clicks_on(String department) throws Throwable {
//
//        if(etsyHomePage.JewelryAc.getText().equalsIgnoreCase(department)){
//            etsyHomePage.JewelryAc.click();
//        } else if(etsyHomePage.clothesS.getText().equalsIgnoreCase(department)){
//            etsyHomePage.clothesS.click();
//        }else if(etsyHomePage.homeL.getText().equalsIgnoreCase(department)){
//            etsyHomePage.homeL.click();
//        } else if (etsyHomePage.toysE.getText().equalsIgnoreCase(department)){
//            etsyHomePage.toysE.click();
//        }else if(etsyHomePage.weddingP.getText().equalsIgnoreCase(department)){
//            etsyHomePage.weddingP.click();
//        }
//    }

//    @Then("^User validate title \"([^\"]*)\"$")
//    public void user_validate_title(String title) throws Throwable {
//        String actualTitle= Driver.driver.getTitle();
//        Assert.assertEquals(title, actualTitle);
    //}

    @When("^User clicks on Free Shipping checkbox$")
    public void user_clicks_on_Free_Shipping_checkbox() throws Throwable {
        BrowserUtils.hover(etsyResultPage.freeShippingCheckBox, Driver.driver);
        etsyResultPage.freeShippingCheckBox.click();
        Thread.sleep(3000);
    }

    @Then("^Verify all results have \"([^\"]*)\" label$")
    public void verify_all_results_have_label(String label) throws Throwable {
        for (WebElement element : etsyResultPage.freeShippingLabels) {
            Assert.assertEquals(label, element.getText().trim());
        }
    }

        @When("^User clicks on Over Price checkbox$")
        public void user_clicks_on_Over_Price_checkbox() throws Throwable {
            etsyResultPage.over1000Checbox.click();
        }

        @Then("^User verifies all items prices are over$")
        public void user_verifies_all_items_prices_are_over() throws Throwable {
        for(WebElement element:etsyResultPage.resultPices){
            String number=element.getText().replace(",","");
            System.out.println(number);
            if(!number.isEmpty()) {
             double price=Double.parseDouble(number);

             Assert.assertTrue(price>=1000);

}}
        }
    }






