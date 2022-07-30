@address
Feature: User can add address in to account

  Scenario Outline: User can add address in to account

    Given User goes to main page
    When user goes to the login page
    And User login using "rcrhfybbkzkulyzlqx@nthrl.com" and "lolopass"

    And User goes to my "Addresses" page at my account page on url "https://mystore-testlab.coderslab.pl/index.php?controller=addresses"
    And user adds a new address
    And User enters a new alias <alias> address <address> city <city> postal <postal> country <country> phone <phone>
    And User verify created alias <alias> address <address> city <city> postal <postal> country <country> phone <phone>

    And User deletes the address
    Then User can see message that address was removed with text "Address successfully deleted!"

    And User closes shop page

    Examples:
      |alias|address|city|postal|country|phone|
      |Lolo|New Street|Warsaw|33-333 |United Kingdom|123456789|