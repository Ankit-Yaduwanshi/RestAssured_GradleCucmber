Feature: Demo

  @test
  Scenario: Running a SpringBoot Gradle project with Cucumber
    Given Able to launch SpringBoot project with Gradle and cucumber

  @test1, @test
  Scenario: Parameterizing the steps and passing values as arguments
    Given By parameterizing i am able to print my first name "Ankit" and last name "Yaduwanshi"

  @test2, @test
  Scenario Outline: parameterizing the steps and passing values as arguments for multiple arguments
    Then By parameterizing and doing same action with multiple arg i am able to print my first name <fname> and last name <lname>
    Examples:
      | fname     | lname     |
      | "Ankit" | "Yaduwanshi" |
      | "Aditya" | "Yaduwanshi" |