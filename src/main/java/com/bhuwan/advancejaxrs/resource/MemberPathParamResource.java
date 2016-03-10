/**
 * 
 */
package com.bhuwan.advancejaxrs.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * access like: http://localhost:8080/advancejaxrs/api/abcd/text?query=queryvalue
 * 
 * if you make this class singleton then you will get exception which mention that you cannot inject pathparam and queryparam because this
 * class is initialized before the request call actually made.
 * 
 * You cannot have class member path param in case of singleton request scope. Only method path params are supported.
 * 
 * @author bhuwan
 *
 */
@Path("{pathparam}/text")
public class MemberPathParamResource {

    private @PathParam("pathparam") String pathParam;
    private @QueryParam("query") String queryParam;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String test() {
        return "it works fine path param: " + pathParam + " and query param: " + queryParam;
    }
}
