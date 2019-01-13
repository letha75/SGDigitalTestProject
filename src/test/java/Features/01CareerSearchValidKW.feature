Feature: CareerSearch based on valid keyword
  Career Search based on valid keyword and filter based on location

  Scenario: Career Search based on valid keyword and filter based on location
    Given User launch SGDigital homepage
    Then Careers menu item is displayed
    When User clicks on Careers link
    Then Careers Page is displayed with current vacancies listed
    And User enters valid keyword as Analyst
    And I click enter key
    Then Vacancies based on the criteria is displayed
    And user selects location as Singapore
    Then vacancies specific to location is displayed
    Then Close Browser