package com.jf.home.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GithubSteps {
  
  @When("^I GET \"([^\"]*)\"$")
  public void iGET(String Url) throws Throwable {
      // Write code here that turns the phrase above into concrete actions
      throw new PendingException();
  }

  @Then("^the response code should be (\\d+)$")
  public void theResponseCodeShouldBe(int response) throws Throwable {
      // Write code here that turns the phrase above into concrete actions
      throw new PendingException();
  }

}
