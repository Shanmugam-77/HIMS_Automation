Feature: Add Organization
  As an admin
  I want to add a new organization
  So that it is available in the admin module.
  
  @Regression
  Scenario: Verify adding an organization
  Given I open the application
  When I navigate to the admin category
  And I click on the Add Organization button
  And I fill in the organization details
  
      | OrgName       | RandomOrgName     |
      | OrgEmail      | RandomOrgEmail    |
      | OrgContact    | RandomOrgContact  |
      | OrgAddress    | RandomOrgAddress  |
      | Country       | RandomCountry     |
      | CountryRegion | RandomRegion      |
      | CityName      | RandomCity        |
      | PostalCode    | RandomPostalCode  |
      
      And I submit the form
      Then the add organization should be added successfully