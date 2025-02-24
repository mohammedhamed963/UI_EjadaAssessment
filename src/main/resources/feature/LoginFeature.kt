package feature

class LoginFeature {
    Feature: User login

    Scenario: Valid login
    Given The user is on the login page
    When The user enters valid credentials
    Then The user should be logged in successfully

}