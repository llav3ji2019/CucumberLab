package step;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.home.HomePage;
import page.login.LoginPage;
import utils.user.User;
import utils.user.UserHandler;

import static org.apache.commons.lang3.BooleanUtils.isTrue;
import static org.hamcrest.MatcherAssert.assertThat;

public class LogOutStep extends BaseTest {
    private LoginPage loginPage;
    private HomePage homePage;

    @Before
    public void initialisation(){
        init();
    }

    @After
    public void teardown(){
        exit();
    }

    @Given("I open main page as {string} with {string} and {string} for log out")
    public void openMainPageForLogOut(String name, String login, String password) {
        User user = new UserHandler().setLogin(login)
                .setName(name)
                .setPassword(password)
                .build();
        homePage = new LoginPage().signIn(user);
    }

    @When("I click on exit bar")
    public void clickOnExitBar() {
        homePage = homePage.clickOnExitBar();
    }

    @And("I click on log out button")
    public void clickOnLogOutButton() {
        homePage = homePage.clickOnExitButton();
    }

    @And("I confirm the exit")
    public void confirmTheExit() {
        loginPage = homePage.clickOnConfirmExitButton();
    }

    @Then("I'm going to the login page")
    public void logOutFromYourAccount() {
        assertThat("Can't find sign in button", isTrue(loginPage.checkPage()));
    }
}
