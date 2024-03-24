Feature: SmartBearTesting_Login


@pagetitle @Sanity
Scenario Outline: Verify pagetitle

	#Given Open browser and navigate
	When Verify title
	
@verifylogin	@Sanity
Scenario Outline: Verify login functionality

	#Given Open browser and navigate

	When Enter username and password "<Username>" "<Password>"
	And Click login button

	Then Verify login is successful
	And Close the application

Examples: 
|Username|Password| 
|Tester|test|



