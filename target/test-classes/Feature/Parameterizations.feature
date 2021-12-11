#@Regression - if we write class level then all scenario will come under the Tags 
Feature: This feature describes the parameterization in Cucumber

Scenario: Passing single numeric parameter to the Gherkin step
     Given I have 5 and 6
     When I add them
     Then Print result
@Regression @smoke  
 Scenario: Passing String parameter to the gherkin step
     Given I have two words like "India" and "China"
     Then print them in alphabetic order
 @smoke  
Scenario: Passing float parameter to gherkin step
     Given I have two float numbers 3.14 and 5.34
     Then add both float numbers 
     And Print float result
 @Regression  
Scenario: Passing list of parameters to the gherkin step
    Given I have following number:
         |10|
         |11|
         |12|
         |13|
         |14|
         |15|
    Then print all numbers from list
@Regression 
Scenario: Passing table of parameters to the gherkin step
      Given I have follwing table:
#     In below table first coloumn always key(whrnwe want to get in key value pair)
      |firstList|11|12|13|14|15|16|
      |secondList|18|19|20|21|22|23|
      Then print them in row coulmn format
 
# Multiple time this scenario used  
   
Scenario Outline:
      Given  I have two numbers from <row-number> 
      When I add them
      Then Verify if result is prime  
#      Given I have <num1> and <num2>

      
Examples:
     |row-number|
     |1|
     |2|
     |3|
     |4|
     |5|
     |6|
     
#     |...|
#     |1000|
     
     
#     |num1|num2|
#     |9|2|
#     |13|3|
#     |2|7|
#     |4|3|
#     |11|6|
#     |21|8|    
