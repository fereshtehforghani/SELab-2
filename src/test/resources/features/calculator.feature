@tag
Feature: Calculator
  Scenario: reverse
    Given One input value 10 and operator rvs
    When I reverse the value
    Then I expect the result 0.1

  Scenario Outline: reverse
    Given One input value <Input> and operator <op>
    When I reverse the value
    Then I expect the result <result>
    Examples:
      | Input | op | result |
      | 4| rvs| 0.25|
      | -2| rvs| -0.5|
      | 6| rvs| 0.1666|
      | 8| rvs| 0.125|
#      | 0| rvs| 0|

  Scenario: squareroot
    Given One input value 4 and operator sqrt
    When I squareroot the value
    Then I expect the result 2

  Scenario Outline: reverse
    Given One input value <Input> and operator <op>
    When I squareroot the value
    Then I expect the result <result>
    Examples:
      | Input | op | result |
      | 9| sqrt| 3|
      | 0| sqrt| 0|
      | 2| sqrt| 1.41421356|
      | 25| sqrt| 5|
#      | -4| sqrt| -4|