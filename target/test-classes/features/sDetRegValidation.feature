@tag
Feature: Title of your feature
  SDET registration validation

  @tag1
  Scenario: Validate that user can register for SDET training
    Given that user is on the UltimateQA landing page
    When user clicks on java SDET Academy link
    And types in first namane in the first name field
    And types in last name in the last name field
    And types in email address in the email address field
    And types in phone number in the phone number field
    And click on the Get Early Access button
    Then user should be successfully registered