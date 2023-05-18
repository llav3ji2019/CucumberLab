package step;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.chat.ChatPage;
import page.home.HomePage;
import page.login.LoginPage;
import utils.Exception.PersonNotFound;
import utils.user.User;
import utils.user.UserHandler;

import static org.apache.commons.lang3.BooleanUtils.isTrue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.fail;

public class SendMessageStep extends BaseTest {
    private String message;
    private HomePage homePage;
    ChatPage chatPage;

    @Before
    public void initialisation(){
        init();
    }

    @After
    public void teardown(){
        exit();
    }

    @Given("I open main page as {string} with {string} and {string} for send message")
    public void openMainPageForMessage(String name, String login, String password) {
        User user = new UserHandler().setLogin(login)
                .setName(name)
                .setPassword(password)
                .build();
        homePage = new LoginPage().signIn(user);
    }

    @And("I open chat with {string}")
    public void openChatWithPerson(final String personName) {
        try {
            chatPage = homePage.openFriendPage().openChat(personName);
            assertThat("We are trying to send message to wrong friend", isTrue(chatPage.getChatTitle().equals(personName)));
        }
        catch (PersonNotFound e) {
            fail("Person wasn't found");
        }
    }

    @When("I send {string} to {string}")
    public void sendMessageToPerson(String message, String personName) {
        this.message = message;
        assertThat("We are trying to send message to wrong friend", isTrue(chatPage.getChatTitle().equals(personName)));
        chatPage.sendMessage(message);
    }

    @Then("Message is sent")
    public void messageIsSent() {
        assertThat("Message wasn't sent", isTrue(message.equals(chatPage.getLastMessageText())));
    }

}
