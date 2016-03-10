/**
 * 
 */
package com.bhuwan.advancejaxrs.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * By default all the resources are Request Scope ie. new instance will be created per request. you can make it Singleton by @Singleton
 * annotation. Singleton scope means same instance will be shared through out the life cycle.
 * 
 * @author bhuwan
 *
 */
@Path("/requestscope")
public class RequestScopeResource {

    private int count;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String test() {
        count += 1;
        return "it works fine! method call count: " + count + " times.";
    }
}
