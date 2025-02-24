package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import utils.DriverManager;

import java.util.List;
import java.util.Map;

import io.cucumber.datatable.DataTable;

public class LoginSteps {
    WebDriver driver = DriverManager.getDriver();
    LoginPage loginPage = new LoginPage(driver);

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        driver.get(DriverManager.getURL());
    }

    @When("the user enters invalid credentials")
    public void the_user_enters_invalid_credentials(DataTable dataTable) {
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : rows) {
            loginPage.enterUsername(row.get("username"));
            loginPage.enterPassword(row.get("password"));
            loginPage.clickLogin();
        }
    }

    @Then("an error message {string} should be displayed")
    public void an_error_message_should_be_displayed(String expectedMessage) {
        assert loginPage.getErrorMessage().equals(expectedMessage);
        DriverManager.quitDriver();
    }
}
