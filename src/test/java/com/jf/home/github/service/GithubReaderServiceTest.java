package com.jf.home.github.service;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;

import javax.inject.Inject;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import gherkin.deps.com.google.gson.JsonObject;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.GetMethod;

public class GithubReaderServiceTest {

  private String githubUrl = "https://api.github.com/users/joeyfaherty";

  @Inject
  private GithubReaderService sut;

  private HttpClient client = new HttpClient();
  private GetMethod getMethod;
  private int responseStatusCode;

  @Test
  public void testReadJsonFromUrl() throws IOException, JSONException, HttpException {

    sut.readJsonFromUrl(githubUrl);
    
    getMethod = new GetMethod(githubUrl);
    responseStatusCode = client.executeMethod(getMethod);

    assertEquals(responseStatusCode, 200);

  }

}
