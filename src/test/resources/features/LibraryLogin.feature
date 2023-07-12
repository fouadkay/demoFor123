Feature: Login feature

  @librarian
  Scenario: Login as a librarian
    Given I am on the login page
    When I login as a librarian
    Then dashboard should be displayed



  @all_accounts
  Scenario Outline: Verify user information <email>
    Given I am on the login page
    When I login using "<email>" and "<password>"
    Then account holder name should be "<name>"

    @librarians
    Examples:
      | email | password | name |
      | librarian13@library | libraryUser | Test Librarian 13 |
      | librarian14@library | libraryUser | Test Librarian 14 |
      | librarian15@library | libraryUser | Test Librarian 15 |
      | librarian16@library | libraryUser | Test Librarian 16 |
      | librarian17@library | libraryUser | Test Librarian 17 |