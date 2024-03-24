Feature: SmartBearTesting_Homepage
#Background: Execute open browser and navigate command
	#Given Open browser and navigate

@Createneworder @Regression
Scenario Outline: Create a new order

	
	Given Enter username and password "<Username>" "<Password>"
	Given Click login button
	Given Verify login is successful


	When Enter Product information "<Product>" "<Quantity>" "<Priceperunit>" "<Discount>"
	When Enter Address information "<Customer_name>" "<Street>" "<City>" "<State>" "<Zip>"
	When Enter Payment information
	When Click process button

	Then Verify the new order created successfully
	
Examples: 
|Username|Password|Product|Quantity|Priceperunit|Discount|Customer_name|Street|City|State|Zip|
|Tester|test|Screensaver|20|10|2|Thangaraj|firststreet|Chennai|Tamilnadu|600054|
|Tester|test|MyMoney|10|50|5|Raj|secondstreet|Chennai|Tamilnadu|600025|

@Extract @Regression
Scenario Outline: Extract the data	

	
	Given Enter username and password "<Username>" "<Password>"
	Given Click login button
	Given Verify login is successful
	
	When Extract the data from a Webtable
	
	
Examples: 
|Username|Password| 
|Tester|test|