@filterFunction
Feature:Filter feature
  As an automation testing
  I want to check filter studetn on Student page
  So that I want to make sure the Fitler works properly

  @Filter
  Scenario: Verify filter with single criterion
    Given I'm still in Student page with User Name is "[Admin]"
    When I click to Filter button
    When I select Request Status is "Inactive"
    When I click to Apply button
    Then I see the result list filters all Status is "Inactive"