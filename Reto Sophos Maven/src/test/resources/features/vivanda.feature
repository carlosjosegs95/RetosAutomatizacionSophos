@Vivanda
Feature: Sophos challenge refers to Vivanda Page
  An user wants to get an item from Vivanda home page

  @Vivanda @TestCase1
  Scenario: Successful Case
  Narrative: Add an item to the basket

    Given an user enters the vivanda page
    When the user selects a product
    Then the user check the product on basket