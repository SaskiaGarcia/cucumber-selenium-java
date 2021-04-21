Feature: Check login functionality

@test1
  Scenario Outline: Check login is successful with valid credentials
    Given user is on login page
    When user enters <username> and <password>
    And clicks on login button
    Then user is navigated to the home page

    Examples: 
      | username        | password         |
      | Saskia.Garcia34 | ModulrQaTest123* |

@test2
  Scenario Outline: Check login is unsuccessful with invalid credentials
    Given user is on login page
    When user enters <username> and <password>
    And clicks on login button
    Then user should see error

    Examples: 
      | username        | password         |
      | Saskia.Garcia34 | ModulrQaTest123  |
      | SaskiaGarcia34  | ModulrQaTest123* |
      | SaskiaGarc34    | ModulrTest123*   |

@test3
  Scenario Outline: Check login is unsuccessful with empty credentials
    Given user is on login page
    When user enters <username> and <password>
    And clicks on login button
    Then user should see required fields error

    Examples: 
      | username        | password         |
      | Saskia.Garcia34 |                  |
      |                 | ModulrQaTest123* |
      |                 |                  |

@test4      
    Scenario: Check user can request to reset password
    Given user is on login page
    And clicks on forgotten password
    Then user is navigated to the reset access page