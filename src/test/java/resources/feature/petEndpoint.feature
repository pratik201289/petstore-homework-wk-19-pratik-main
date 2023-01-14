Feature: Testing different request of pets on the petstore application
  As a User I check different endpoints of pet sections
    Scenario: check all pets added into petstores and verify status code
    When I create a pet with  endpoint id
    Then I must get back a valid status code 200

    Scenario: get  single pet data using by id
      When I send a get request to pet using petId endpoint
      Then I must get single pet data

     Scenario: update pet with name
       When I update a pet with name
       Then I verify with endpoint pet id

      Scenario: Delete pet with using id and vberify
        When I delete a pet with endpoint of id
        Then I must get valid response


