Feature: Testing different request of user on the petstore application
  As a User I check different endpoints of user sections
  Scenario: check user added into petstores and verify status code
    When I create a user
    Then I must get back a valid status code

  Scenario: get  single pet data using by id
    When I send a get request to user using username endpoint
    Then I must have valid status code 200

  Scenario: update pet with name
    When I update a user with name
    Then I verify with endpoint by username and validate status

  Scenario: Delete pet with using id and vberify
    When I delete a user with endpoint of username
    Then I must get valid response of deleted user
