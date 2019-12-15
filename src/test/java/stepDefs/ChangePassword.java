package stepDefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import pages.OrangeLoginPage;
import pages.OrangeMainPage;
import utilities.Configuration;
import utilities.Driver;

public class ChangePassword {
    OrangeLoginPage orangeLoginPage=new OrangeLoginPage();
    OrangeMainPage orangeMainPage= new OrangeMainPage();

    @Given("^User navigate to login page$")
    public void user_navigate_to_login_page() throws Throwable {
        Driver.driver.get(Configuration.getProperties("OrangePageUrl"));
    }

    @Then("^User provides login \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void user_provides_login_and_password(String login, String password) throws Throwable {
        orangeLoginPage.loginField.sendKeys(login);
        orangeLoginPage.password.sendKeys(password);
        orangeLoginPage.loginButton.click();
    }

    @Then("^Change password for Fiona Grace$")
    public void change_password_for_Fiona_Grace() throws Throwable {
        orangeMainPage.adminButton.click();
        orangeMainPage.fionaGraceButton.click();
        orangeMainPage.editButton.click();
        orangeMainPage.changePasswordcheckBox.click();
        orangeMainPage.newPasswordField.sendKeys("abcd1234");
        orangeMainPage.confirmPasswordField.sendKeys("abcd1234");
        orangeMainPage.saveButton.click();
    }

    @Then("^Verify it is changed by signing in again$")
    public void verify_it_is_changed_by_signing_in_again() throws Throwable {
        orangeMainPage.welcomeButton.click();
        orangeMainPage.logoutButton.click();
        orangeLoginPage.loginField.sendKeys("fiona.grace");
        orangeLoginPage.password.sendKeys("abcd1234");
        orangeLoginPage.loginButton.click();
        String actual=orangeMainPage.welcomeButton.getText();
        String expected= "Welcome Fiona";
        Assert.assertEquals(expected, actual);
    }

}
