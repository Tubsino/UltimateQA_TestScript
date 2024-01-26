@tag
Feature: Title of your feature
  Blog feature validation

  @tag1
  Scenario: Validate that user can read blog posts
    Given that user is on the UltimateQA landing page
    When user clicks on the Blog link
    And clicks on a post
    Then user should be able to open the post successfully
    And user goes back to the previous page
    And clicks on another post
    Then user should be able to open it successfully