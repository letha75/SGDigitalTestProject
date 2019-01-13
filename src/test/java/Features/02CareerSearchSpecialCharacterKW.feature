Feature: CareerSearch based on special character keyword
  Career Search based on special character keyword

  Scenario: Career Search based on special character keyword
    Given User launch SGDigital homepage
    Then Careers menu item is displayed
    When User clicks on Careers link
    Then Careers Page is displayed with current vacancies listed
    And User enters special character keyword as c$
    And I click enter key
    Then Vacancies based on the criteria is displayed
    Then Close Browser
