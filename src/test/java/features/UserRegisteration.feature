Feature: User Registeration
	I want to check that the user can register in our e-commerce website.
	
	Scenario Outline: User Registeration
	Given the user in the home page
	When I click on register link
	And I entered the "<firstname>", "<lastname>", "<email>", "<password>"
	Then The registeration page displayed successfully "<email>", "<password>"
	
	Examples:
		| firstname | lastname | email | password |
		| Merna | Ashraf | test3@gmail.com | 123456 |
		| Moataz | Nabil | test4@gmail.com | 123456 |
