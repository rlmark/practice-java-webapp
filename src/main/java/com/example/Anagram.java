package com.example;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by rebeccamark on 2/26/15.
 */
@Path(Anagram)
public class Anagram {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getAnagram() {
        return "Really got it";
    }
}
