Feature: Store github metrics

	Scenario: Store metrics from Github API
		When I GET "https://www.githubarchive.org"
		And the response code is 200
		Then store the response
		