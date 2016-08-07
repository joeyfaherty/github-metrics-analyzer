package com.metrics.github.web.resource;

import com.metrics.github.domain.User;
import com.metrics.github.service.GithubReader;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("user")
public class UserResource {

    private GithubReader readerService;

    public UserResource() {
        this.readerService = new GithubReader();
    }

    @GET
    @Produces("text/plain")
    public String getUserMetrics() {
        User user = readerService.readParseToUserObject();
        return user.getName();
    }
}
