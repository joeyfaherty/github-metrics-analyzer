Feature: Connect to github API

	Scenario: Connect to github API
		When I GET "https://www.githubarchive.org"
		Then the response code should be 200