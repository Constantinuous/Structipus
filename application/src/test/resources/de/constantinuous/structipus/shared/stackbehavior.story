Narrative:
In order to learn to with JBehave using Eclipse
As a junior Java developer though senior in .Net and in BDD
I want to define the behaviour of a custom stack

Scenario: I push an item onto the stack
Given I have an empty stack
When  I push an item 'orange'
Then  I should count 1

Scenario: I pop from the stack
Given I have an empty stack
When  I push an item 'apple'
And   I pop the stack
Then  I should count 0