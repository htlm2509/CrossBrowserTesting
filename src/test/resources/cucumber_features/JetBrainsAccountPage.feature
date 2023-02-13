@ParallelExecution
Feature: JetBrains Account Page
  As a customer
  I want to be able to open JetBrains Account page
  So that I can proceed with Sign In/Up procedure

  Scenario: Open jQuery home page and proceed to Download Builder page
    Given I am an anonymous customer with clear cookies
    When I open the JetBrains home page
    And I click Account button
    Then JetBrains Account page is opened
