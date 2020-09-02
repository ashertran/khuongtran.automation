@sortFunction
Feature:Sort feature
  As an automation testing
  I want to check sort on each header on Student table
  So that I want to make sure the sort in header works properly

  @Sort
  Scenario: Verify the First Name column sort properly
    When I click to sort icon in the First Name header
    Then The result grid will be sort descending
    When I click to sort icon in the First Name header one time
    Then The result grid will be sort ascending
