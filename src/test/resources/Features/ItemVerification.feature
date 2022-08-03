@tag smokeTest
Feature: ItemVerification
  
    Scenario Outline: Verify the item description
    Given User launches the "<page>"
    And User clicks on the hamburger menu in the top left corner
    And User scrolls down and clicks on the "<category>" link under the "<section>"
    And User clicks on the "<product>" under "<sub section>"
    And user scroll down and filter the results by "<brand>"
    And User sort the results with "<criteria>"
    When User clicks the second highest priced item
    Then Application switches the window "<brand>"
    And Verify the "<product-section>" is present

    Examples: 
      | page	| category 										| section  						|	product			| sub section 				| brand		| criteria					| product-section |
      | Home 			| TV, Appliances, Electronics	| shop by department 	|	Televisions	|	tv, audio & cameras	|	Samsung	| Price:High to Low	| About this item	|
