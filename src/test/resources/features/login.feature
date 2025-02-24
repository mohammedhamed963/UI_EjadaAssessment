Feature: Login Functionality

  Scenario Outline: Login with invalid credentials
    Given the user is on the login page
    When the user enters invalid credentials
      | username   | password   |
      | <username> | <password> |
    Then an error message "<errorMessage>" should be displayed

    Examples:
      | username    | password    | errorMessage |
      | invalidUser1 | wrongPass1 | Username and password do not match any user in this service |
      | invalidUser2 | wrongPass2 | Username and password do not match any user in this service |
      | invalidUser3 | wrongPass3 | Username and password do not match any user in this service |
      | invalidUser4 | wrongPass4 | Username and password do not match any user in this service |
