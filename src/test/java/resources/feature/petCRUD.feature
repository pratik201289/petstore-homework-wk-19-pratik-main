Feature: Pet creation data
  As a user I want to test pet data application

  Scenario Outline: CRUD Test
    Given Pet store creating new pet data
    When I create a new pet by providing the information id "<id>" idFirst "<idFirst>" name "<name>" nameFirst "<nameFirst>" photoUrl"<photoUrl>"idsecond "<idsecond>" namesecond "<namesecond>" status"<status>"
    Then I verify A pet with "<id>" is created
    And I update the pet information  id "<id>" idFirst "<idFirst>" name "<name>" nameFirst "<nameFirst>" photoUrl"<photoUrl>"idsecond "<idsecond>" namesecond "<namesecond>" status"<status>"
    And A pet update with "<id>" is successfully
    And I delete the pet that created with "<id>"
    Then the pet deleted succesfully from the application

    Examples:
      | id | idFirst | name  | nameFirst | photoUrl              | idsecond | namesecond | status        |
      | 23 | 45      | bunny | rabbit    | http://dummyimage.com | 56       | bunny2     | available     |
      | 24 | 46      | dear  | tiger     | http://dummyimage.com | 57       | tiger2     | not available |
