Feature: Show github metrics

	Scenario: Show metrics from Github API
		When I enter a time from 3 days ago to now on the UI
		Then all metrics for that time period are displayed