@FlightSearch
Feature: Title of your feature
  I want to use this template for my feature file

Background:
Given User is on the Emirates Web Application

  @OneWay
  Scenario: As an Emirates user I want to Search one way flight
    When I set Delhi as departure city
    And I set Dubai as arrival city
    And I set the Detarture date as 20/07/2019 in dd-mm-yyyy format
    And I set One Way as journey type
    And I initialize the search
    Then I should see flight search results

  @Return
  Scenario: As an Emirates user I want to Search return flight
    When I set Delhi as departure city
    And I set Dubai as arrival city
    And I set the Detarture date as 20/07/2019 in dd-mm-yyyy format
    And I set the Return date as 25/07/2019 in dd-mm-yyyy format
    And I initialize the search
    Then I should see flight search results