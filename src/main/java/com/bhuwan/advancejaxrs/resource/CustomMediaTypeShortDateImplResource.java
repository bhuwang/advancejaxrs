/**
 * 
 */
package com.bhuwan.advancejaxrs.resource;

import java.util.Calendar;
import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * @author bhuwan
 *
 */
@Path("shortdate")
public class CustomMediaTypeShortDateImplResource {
    @GET
    @Produces("text/shortdate")
    public Date test() {
        return Calendar.getInstance().getTime();
    }
}
