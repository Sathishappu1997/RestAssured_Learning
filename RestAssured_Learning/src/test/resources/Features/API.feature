Feature: To validate the all the basic request of rahuk shetty

Scenario Outline: To test all the four request methods
Given Initilise Base URI link
When call he hashmap for post method
Then get the response for post method with "<name>" and "<lang>"
And Validate Post response

Examples:
|name|lang|
|Frank|English|
|Joshi|Tamil|
