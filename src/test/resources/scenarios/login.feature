Feature: Now I am currently testing login in Ok.ru

  Scenario Outline: I want to login with correct credentials
    Given I am on the login page
    When I want to login as <name> with <login> and <password>
    Then I'm going to the main page as <name>
    Examples:
      | name                    | login             | password             |
      | "botS23AT9 botS23AT9"   | "botS23AT9"       | "autotests2023"      |
      | "botS23AT27 botS23AT27" | "botS23AT27"      | "autotests2023"      |
      | " "                     | " "               | " "                  |
      | "hehe"                  | "incorrect login" | "incorrect password" |