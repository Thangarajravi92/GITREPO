Feature: SmartBearAutomation testing



Scenario: Verify login functionality

Given Open browser
Given Launch application

When Enter username and password
When Click login button

Then Verify login is successful

Scenario: Create a new order

Given Login to the application


When Enter Product information
When Enter Address information
When Enter Payment information
When Click process button

Then Verify the new order created successfully