@ParallelExecution
Feature: jQuery ThemeRoller Page
  As a customer
  I want to be able proceed to jQuery ThemeRoller page
  So that I can get acquainted with corresponding information

  Scenario: Open jQuery home page and proceed to ThemeRoller page
    Given I am an anonymous customer with clear cookies
    When I open the jQuery home page
    And I click Themes button
    Then I am redirected to ThemeRoller page
