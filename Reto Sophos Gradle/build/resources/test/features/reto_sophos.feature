@Reto_Sophos
Feature: Reto Sophos
  An user wants to get an item from Vivanda home page

  @TestCase
  Scenario Outline: Successful Case
  Narrative: Add an item to the basket

    Given an user enters the vivanda page
    When the user selects a product
      | number   | <number>   |
      | product  | <product>  |
    Then the user check the product on basket
      | product  | <product>  |

    Examples:
      | number   | product      |
      | 3        | riccadonna   |
      | 1        | ideal        |
      | 2        | raid         |
