@loginFunction
Feature:Login feature
  As an automation testing
  I want to login the web app testing
  So that I want to make sure login works properly

  @Login
  Scenario: Login the web app testing
    Given Launch to the web app testing
    When I input to email textbox with variable data "admin@test123"
    And I input to password textbox with variable data "test123"
    And I click to Login button


