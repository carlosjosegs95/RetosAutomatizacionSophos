@Gorest_API
Feature: Sophos Challenge refers to Gorest API
  An user wants to register using the Gorest API

  @Gorest @TestCase1
  Scenario Outline: Successful Case
  Narrative: Register an user with the Gorest API

    When an user create a register using his data
      | first_name | <first_name>|
      | last_name  | <last_name> |
      |  gender    | <gender>    |
      |  email     | <email>     |
      |  status    | <status>    |
    Then the user check the successful create

    Examples:
      | first_name | last_name | gender | email      | status |
      | Carlos     | Guerrero  | male   | @gmail.com | active |