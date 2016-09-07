package com.metrics.github.web.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.metrics.github.utility.FileLoaderUtil;

@Path("/current-version")
public class VersionPageResource {

    public static final String versionDetails;

    private static final String fileName = "version.txt";

    static {
        versionDetails = FileLoaderUtil.convertFileContentToString(fileName);
    }

    @GET
    @Produces("text/plain")
    public String getProjectVersion() {
        return versionDetails;
    }

}
