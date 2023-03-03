
@Booking
Feature:Booking
  A feature to book the hotel

  Background: Login successful
    Given a user is on the home page
    When  a user navigates to the Login page using "http://adactinhotelapp.com/"
    And a user enter "sthembiso16" and "3755RP"
    And a user clicks the login button
    Then a user has login successfully

  Scenario Outline: Book Hotel successfully
    Given a user fill in the booking form
    And a user enters "<firstname>", "<lastname>", "<bill-address>", "<card-number>", "<cvv-number>"
    Then the hotel was booked successfully

    Examples:
      |firstname| lastname| bill-address| card-number| cvv-number|
      | Sthesh  | Kubheka |  1476 Cameroon Street, Ranburg, Johannesburg, 1111  | 1111111111111111  |  111 |



