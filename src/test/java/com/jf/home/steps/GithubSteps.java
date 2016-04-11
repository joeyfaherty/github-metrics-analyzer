package com.jf.home.steps;

import static org.junit.Assert.assertEquals;

import com.jf.home.github.service.GithubReaderService;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GithubSteps {
  
  private GithubReaderService githubReaderService = new GithubReaderService();
  
  @When("^I GET \"([^\"]*)\"$")
  public void iGET(String url) throws Throwable {
      assertEquals(200, githubReaderService.retrieveRequestStatus(url));
  }

  @Then("^the response code should be (\\d+)$")
  public void theResponseCodeShouldBe(int response) throws Throwable {
      // Write code here that turns the phrase above into concrete actions
      throw new PendingException();
  }

}
