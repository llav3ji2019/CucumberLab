package step;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.home.HomePage;
import page.login.LoginPage;
import utils.user.User;
import utils.user.UserHandler;

import static org.apache.commons.lang3.BooleanUtils.isTrue;
import static org.hamcrest.MatcherAssert.assertThat;

public class LoginStep extends BaseTest {

    private LoginPage loginPage;
    private HomePage homePage;

    @Before
    public void setUp(){
        init();
    }

    @After
    public void tearDown(){
        exit();
    }

    @Given("I am on the login page")
    public void openLoginPage() {
        loginPage = new LoginPage();
    }

    @When("I want to login as {string} with {string} and {string}")
    public void enterUserData(String name, String login, String password) {
        User user = new UserHandler().setLogin(login)
                .setName(name)
                .setPassword(password)
                .build();
        homePage = loginPage.signIn(user);
    }

    @Then("I'm going to the main page as {string}")
    public void signInToTheMessenger(String name) {
        assertThat("User should see home page", isTrue(homePage.checkPage(name)));
    }
}
