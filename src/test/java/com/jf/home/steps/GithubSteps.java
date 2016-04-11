package com.jf.home.steps;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;

import com.jf.home.github.service.GithubReaderService;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GithubSteps {
  
  private GithubReaderService githubReaderService = new GithubReaderService();
  
  private HttpResponse response;
  
  @When("^I GET \"([^\"]*)\"$")
  public void callGithubApi(String url) throws ClientProtocolException, IOException {
    response = githubReaderService.retrieveRequestResponse(url);
  }
  
  @When("^the response code is (\\d+)$")
  public void validateResponseCode(int arg1) {
      assertEquals(200, response.getStatusLine().getStatusCode());
  }

  @Then("^store the response$")
  public void storeJsonResponse() {
      // Write code here that turns the phrase above into concrete actions
      throw new PendingException();
  }

}
