/**
 * 
 */
package com.bhuwan.advancejaxrs.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * 
 * @author bhuwan
 *
 */
@Path("/test")
public class MyResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String test() {
        return "it works fine !!";
    }
}
