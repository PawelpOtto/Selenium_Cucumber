
@order
Feature: Shop order

  Scenario: User can order on the shop

    Given User goes to main
    When User sign in
    And User login by "rcrhfybbkzkulyzlqx@nthrl.com" and "lolopass"

    When User clicks clothes and choose Hummingbird Printed Sweater
    And User checks the discount "SAVE 20%"
    And User chooses "M" size and quantity "5" and I add item to cart
    Then User confirms and orders

    When User confirms address
    And User chooses PrestaShop and Pay by check
    Then User takes screenshot


    And User closes browser
