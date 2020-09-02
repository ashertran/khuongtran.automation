@checkAPItoGet
  Feature: API Testing

    Scenario: Get location
      Given The api are up and running for "https://my-json-server.typicode.com"
      When I perform a get request to "/typicode/demo/posts/1"
      And  I perform the request
      Then The response code should be 200
      And I should see Json response with a pairs on a filters
      | id        | 1        |
      | title     | Post 1   |
