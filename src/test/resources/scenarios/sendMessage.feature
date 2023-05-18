Feature: Now I am currently testing sending messages in Ok

  Scenario: I want to send message
    Given I open main page as "botS23AT9 botS23AT9" with "botS23AT9" and "autotests2023" for send message
    And I open chat with "Павел Емельянов"
    When I send "Hello, my friend" to "Павел Емельянов"
    Then Message is sent
