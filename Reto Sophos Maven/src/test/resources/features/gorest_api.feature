@Gorest_API
Feature: Sophos Challenge refers to Gorest API
  An user wants to register using the Gorest API

  @Gorest @TestCase1
  Scenario: Successful Case
  Narrative: Register an user with the Gorest API

    When an user create a register using his data
    Then the user check the successful create