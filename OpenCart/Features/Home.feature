#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

@tag
Feature: Verification of Header Section
  Header Section is being verified

  @tag1
  Scenario: To validate the header section is in proper position
    Given OpenCart website is ready
    When I launch URL in chrome browser
    Then OpenCart website should load with Header section in proper position

@tag2
  Scenario: To validate header section is visible in all pages
    Given OpenCart website is ready
    When I launch URL in chrome browser
    And I check whether header section is visible in all pages
    Then OpenCart website should load with Header section visible in all pages

  @tag
Feature: Verification of Header Section
  Header Section is being verified


  #@tag2
  #Scenario Outline: 
    #Given I want to write a step with <name>
    #When I check for the <value> in step
    #Then I verify the <status> in step
#
    #Examples: 
      #| name  | value | status  |
      #| name1 |     5 | success |
      #| name2 |     7 | Fail    |
      
