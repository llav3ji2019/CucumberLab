Feature: Now I am currently testing logout from account in Ok.ru

  Scenario Outline: I want to login with correct credentials
    Given I open main page as <name> with <login> and <password> for log out
    When I click on exit bar
    And I click on log out button
    And I confirm the exit
    Then I'm going to the login page
    Examples:
      | name                    | login        | password        |
      | "botS23AT9 botS23AT9"   | "botS23AT9"  | "autotests2023" |
      | "botS23AT27 botS23AT27" | "botS23AT27" | "autotests2023" |