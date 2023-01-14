Feature:  User Data Creating in Petstore application
  As a user I want to test User Application

  Scenario Outline: CRUD Test
    Given Pet store Application running
    When I create new user by providing the information id "<id>" username "<username>" firstName"<firstName>" lastName "<lastName>"  email "<email>" password"<password>" phone "<phone>"userStatus "<userStatus>"
    Then I get that created user  with "<username>" is created
    And I update the user with information  id "<id>" username "<username>" firstName"<firstName>" lastName "<lastName>"  email "<email>" password"<password>" phone "<phone>"userStatus "<userStatus>"
    And I verify user updated with "<username>" successfully
    And I delete created user with username "<username>"
    Then The user deleted successfully

    Examples:
      | id | username | firstName | lastName | email             | password | phone       | userStatus |
      | 01 | shah     | makan     | patel    | m123@gmail.com    | password1| 0203456535  | active     |
      | 02 | taylor   | shah      | shah     | m345@gmail.com    | password1| 0209873654  | active     |
      | 03 | robert   | taylor    | patel    | shah203@gmail.com | password1| 02009973472 | active     |