$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("API Check_in.feature");
formatter.feature({
  "line": 2,
  "name": "API Testing",
  "description": "",
  "id": "api-testing",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@checkAPItoGet"
    }
  ]
});
formatter.scenario({
  "line": 4,
  "name": "Get location",
  "description": "",
  "id": "api-testing;get-location",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "The api are up and running for \"https://my-json-server.typicode.com\"",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I perform a get request to \"/typicode/demo/posts/1\"",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "I perform the request",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "The response code should be 200",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "I should see Json response with a pairs on a filters",
  "rows": [
    {
      "cells": [
        "id",
        "1"
      ],
      "line": 10
    },
    {
      "cells": [
        "title",
        "Post 1"
      ],
      "line": 11
    }
  ],
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "https://my-json-server.typicode.com",
      "offset": 32
    }
  ],
  "location": "APISteps.the_api_are_up_and_running_for(String)"
});
formatter.result({
  "duration": 3380011499,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "/typicode/demo/posts/1",
      "offset": 28
    }
  ],
  "location": "APISteps.i_perform_a_get_request_to(String)"
});
formatter.result({
  "duration": 158901,
  "status": "passed"
});
formatter.match({
  "location": "APISteps.i_perform_the_request()"
});
formatter.result({
  "duration": 891015900,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "200",
      "offset": 28
    }
  ],
  "location": "APISteps.the_responese_code_should_be_code_is(int)"
});
formatter.result({
  "duration": 67919500,
  "status": "passed"
});
formatter.match({
  "location": "APISteps.iShouldSeeJsonResponseWithAPairsOnAFilters(String,String\u003e)"
});
formatter.result({
  "duration": 1034242500,
  "status": "passed"
});
formatter.uri("TCs_Login.feature");
formatter.feature({
  "line": 2,
  "name": "Login feature",
  "description": "As an automation testing\r\nI want to login the web app testing\r\nSo that I want to make sure login works properly",
  "id": "login-feature",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@loginFunction"
    }
  ]
});
formatter.scenario({
  "line": 8,
  "name": "Login the web app testing",
  "description": "",
  "id": "login-feature;login-the-web-app-testing",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 7,
      "name": "@Login"
    }
  ]
});
formatter.step({
  "line": 9,
  "name": "Launch to the web app testing",
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "I input to email textbox with variable data \"admin@test123\"",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "I input to password textbox with variable data \"test123\"",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "I click to Login button",
  "keyword": "And "
});
formatter.match({
  "location": "LoginSteps.launch_to_the_web_app_testing()"
});
formatter.result({
  "duration": 11991647800,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "admin@test123",
      "offset": 45
    }
  ],
  "location": "LoginSteps.i_input_to_email_textbox_with_variable_data(String)"
});
formatter.result({
  "duration": 258951400,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "test123",
      "offset": 48
    }
  ],
  "location": "LoginSteps.i_input_to_password_textbox_with_variable_data(String)"
});
formatter.result({
  "duration": 172731200,
  "status": "passed"
});
formatter.match({
  "location": "LoginSteps.i_click_to_Login_button()"
});
formatter.result({
  "duration": 74367301,
  "status": "passed"
});
formatter.uri("TCs_Student_Filters.feature");
formatter.feature({
  "line": 2,
  "name": "Filter feature",
  "description": "As an automation testing\r\nI want to check filter studetn on Student page\r\nSo that I want to make sure the Fitler works properly",
  "id": "filter-feature",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@filterFunction"
    }
  ]
});
formatter.scenario({
  "line": 8,
  "name": "Verify filter with single criterion",
  "description": "",
  "id": "filter-feature;verify-filter-with-single-criterion",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 7,
      "name": "@Filter"
    }
  ]
});
formatter.step({
  "line": 9,
  "name": "I\u0027m still in Student page with User Name is \"[Admin]\"",
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "I click to Filter button",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "I select Request Status is \"Inactive\"",
  "keyword": "When "
});
formatter.step({
  "line": 12,
  "name": "I click to Apply button",
  "keyword": "When "
});
formatter.step({
  "line": 13,
  "name": "I see the result list filters all Status is \"Inactive\"",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "[Admin]",
      "offset": 45
    }
  ],
  "location": "FilterStudentSteps.i_m_still_in_Student_page_with_User_Name_is(String)"
});
formatter.result({
  "duration": 1072640800,
  "status": "passed"
});
formatter.match({
  "location": "FilterStudentSteps.i_click_to_Filter_button()"
});
formatter.result({
  "duration": 122162900,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Inactive",
      "offset": 28
    }
  ],
  "location": "FilterStudentSteps.i_select_Request_Status_is(String)"
});
formatter.result({
  "duration": 699222600,
  "status": "passed"
});
formatter.match({
  "location": "FilterStudentSteps.iClickToApplyButton()"
});
formatter.result({
  "duration": 432500600,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Inactive",
      "offset": 45
    }
  ],
  "location": "FilterStudentSteps.i_see_the_result_list_filters_all_Status_is(String)"
});
formatter.result({
  "duration": 59415099,
  "error_message": "java.lang.AssertionError: did not expect to find [true] but found [false]\r\n\tat org.testng.Assert.fail(Assert.java:97)\r\n\tat org.testng.Assert.failNotEquals(Assert.java:969)\r\n\tat org.testng.Assert.assertTrue(Assert.java:43)\r\n\tat org.testng.Assert.assertTrue(Assert.java:53)\r\n\tat common.AbstractTest.verifyPassed(AbstractTest.java:57)\r\n\tat common.AbstractTest.verifyTrue(AbstractTest.java:71)\r\n\tat stepDefinitions.FilterStudentSteps.i_see_the_result_list_filters_all_Status_is(FilterStudentSteps.java:41)\r\n\tat ✽.Then I see the result list filters all Status is \"Inactive\"(TCs_Student_Filters.feature:13)\r\n",
  "status": "failed"
});
formatter.uri("TCs_Student_Sorts.feature");
formatter.feature({
  "line": 2,
  "name": "Sort feature",
  "description": "As an automation testing\r\nI want to check sort on each header on Student table\r\nSo that I want to make sure the sort in header works properly",
  "id": "sort-feature",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@sortFunction"
    }
  ]
});
formatter.scenario({
  "line": 8,
  "name": "Verify the First Name column sort properly",
  "description": "",
  "id": "sort-feature;verify-the-first-name-column-sort-properly",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 7,
      "name": "@Sort"
    }
  ]
});
formatter.step({
  "line": 9,
  "name": "I click to sort icon in the First Name header",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "The result grid will be sort descending",
  "keyword": "Then "
});
formatter.step({
  "line": 11,
  "name": "I click to sort icon in the First Name header one time",
  "keyword": "When "
});
formatter.step({
  "line": 12,
  "name": "The result grid will be sort ascending",
  "keyword": "Then "
});
formatter.match({
  "location": "SortStudentSteps.i_click_to_sort_icon_in_the_First_Name_header()"
});
formatter.result({
  "duration": 3675054900,
  "status": "passed"
});
formatter.match({
  "location": "SortStudentSteps.the_result_grid_will_be_sort_descending()"
});
formatter.result({
  "duration": 172535599,
  "status": "passed"
});
formatter.match({
  "location": "SortStudentSteps.i_click_to_sort_icon_in_the_First_Name_header_one_time()"
});
formatter.result({
  "duration": 3311985301,
  "status": "passed"
});
formatter.match({
  "location": "SortStudentSteps.the_result_grid_will_be_sort_ascending()"
});
formatter.result({
  "duration": 97500,
  "status": "passed"
});
});