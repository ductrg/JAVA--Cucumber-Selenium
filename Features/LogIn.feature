Feature: Login Action
As a admin user
I want to login to evasion
So that I can manage the system
  
Scenario: Successful Login with Valid Credentials
	Given User is on LogIn Page
	When User input UserName as 'admin' and Password as '123456'
	And User click submit
	Then Message displayed Login Successfully
	
Scenario: Successful LogOut
	When User LogOut from the Application
	Then Message displayed LogOut Successfully