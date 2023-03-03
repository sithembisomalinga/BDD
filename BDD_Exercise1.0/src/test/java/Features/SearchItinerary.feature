@Search
Feature:Search
  A feature to search the itinerary

  Background: Search booked hotel successfully
    Given a user is on the home page
    When  a user navigates to the Login page using "http://adactinhotelapp.com/"
    And a user enter "sthembiso16" and "3755RP"
    And a user clicks the login button
    Then a user has login successfully

  Scenario: Search hotel was booked successfully
    And a user clicks on search hotel link
    And a user enter order number and click on the go button
    Then the search is successful